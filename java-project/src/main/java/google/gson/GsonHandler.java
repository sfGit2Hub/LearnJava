package google.gson;

import study.collections.MapImmutabel;
import com.google.gson.Gson;
import study.type.Cat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by SF on 2016/12/2.
 */
public class GsonHandler {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        Map<String, String> aliasName = new HashMap<>();
        aliasName.put("sf", "abel");

        MapImmutabel mapImmutabel = new MapImmutabel();
        mapImmutabel.setAge(20);
        mapImmutabel.setSex(1);
        mapImmutabel.setAliasName(aliasName);
        mapImmutabel.setPet(new Cat("mm"));

        System.out.println(gson.toJson(mapImmutabel));

        List<String> listStr = new LinkedList<>();
        listStr.add("aaa");
        listStr.add("bbb");
        listStr.add("ccc");
        System.out.println(gson.toJson(listStr));
    }
}
