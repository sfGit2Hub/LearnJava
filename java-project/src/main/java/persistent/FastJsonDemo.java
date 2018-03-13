package persistent;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import common.use.Foot;
import common.use.Person;
import common.use.Sex;
import common.use.Toe;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by SF on 2018/3/2.
 */
public class FastJsonDemo {
    private static Person person;
    static {
        person = new Person();
        Foot rightFoot = new Foot(50.2, 20.0, 25.0);
        Foot leftFoot = new Foot(50.1, 19.8, 25.0);
        Toe[] leftToes = new Toe[]{ new Toe("1"), new Toe("2"), new Toe("3"), new Toe("4"), new Toe("5")};
        Toe[] rightToes = new Toe[]{ new Toe("1"), new Toe("2"), new Toe("3"), new Toe("4"), new Toe("5")};
//        leftFoot.setToes(Arrays.asList(leftToes));
        rightFoot.setToes(Arrays.asList(rightToes));
        person.setMarried(false).setName("abel")
                .setID("740j92lJU0&n3b#nfas")
                .setAge(20)
                .setLeftFoot(leftFoot)
                .setRightFoot(rightFoot)
                .setSex(Sex.MALE);
    }


    public static void main(String[] args) {
        System.out.println(JSONPath.contains(person, "leftFoot.toes.0"));
        JSONPath.eval(person, "leftFoot.length");

        System.out.println(JSON.toJSONString(new Person()));

        testMapToJSON();
    }

    private static Map<String, Object> convertToSortedMap(String response) {
        Map<String, Object> map = new TreeMap<>();
        JSONObject respJson = JSON.parseObject(response);
        Iterator<String> keys = respJson.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            map.put(key, respJson.get(key));
        }
        return map;
    }

    private static void testJsonObject() {
        JSONObject root = new JSONObject();
        JSONObject leftFoot = new JSONObject();
        JSONArray toes = new JSONArray();
        JSONObject toe1 = new JSONObject();
        JSONObject toe2 = new JSONObject();
        JSONObject toe3 = new JSONObject();
        toe1.put("name", "toe1");
        toe2.put("name", "toe2");
        toe3.put("name", "toe3");
        toes.add(toe1);
        toes.add(toe2);
        toes.add(toe3);
        leftFoot.put("length", 1.0);
        leftFoot.put("weight", 2.0);
        leftFoot.put("thick", 3.0);
        leftFoot.put("toes", toes);
        root.put("leftFoot", leftFoot);

        System.out.println(root.toJSONString());
    }

    private static void testMapToJSON() {
        Map<String, Object> kvMap = new HashMap<>();
        kvMap.put("leftFoot.length", 1.0);
        kvMap.put("leftFoot.weight", 2.0);
        kvMap.put("leftFoot.thick", 3.0);
        kvMap.put("leftFoot.toes.1.name", "toe1");
        kvMap.put("leftFoot.toes.2.name", "toe2");
        kvMap.put("leftFoot.toes.3.name", "toe3");

        JSONObject root = createJSON("leftFoot.length", 1.0, new JSONObject());
        root = createJSON("leftFoot.thick", 2.0, root);
        root = createJSON("leftFoot.toes.1.name", "toe1", root);
        root = createJSON("leftFoot.toes.1.furs.1.num", "2000000000", root);
        root = createJSON("leftFoot.toes.1.furs.2.num", "3000000000", root);
        root = createJSON("titles.1", "title-1", root);
        root = createJSON("titles.2", "title-2", root);
        String personStr = root.toJSONString();
        System.out.println(personStr);
        Person person = JSON.parseObject(personStr, Person.class);
        person.getName();
    }

    private static JSONObject createJSON(String key, Object value, JSONObject root) {
        String[] paths = key.split("\\.");
        JSON parent = root;
        JSON child = null;
        for (int i=0; i<paths.length; i++) {
            String path = paths[i];
            if (i != paths.length-1) {
                String pathNext = paths[i + 1];
                if (isNumeric(pathNext) && !isNumeric(path)) {
                    child = ((JSONObject) parent).getJSONArray(path);
                    if (child == null) {
                        child = new JSONArray();
                        ((JSONObject) parent).put(path, child);
                    } else {

                    }
                } else if (isNumeric(path)) {
                    child = new JSONObject();
                    ((JSONArray) parent).add(child);
                } else {
                    child = ((JSONObject) parent).getJSONObject(path);
                    if (child == null) {
                        child = new JSONObject();
                        ((JSONObject) parent).put(path, child);
                    }
                }
            } else {
                if (isNumeric(path)) {
                    ((JSONArray)parent).add(value);
                    continue;
                }
                ((JSONObject) parent).put(path, value);
            }
            parent = child;
        }
        return root;
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
