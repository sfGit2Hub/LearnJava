package google.gson;

import collections.MapImmutabel;
import com.google.gson.Gson;
import type.Cat;

import java.util.HashMap;
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
    }
}
