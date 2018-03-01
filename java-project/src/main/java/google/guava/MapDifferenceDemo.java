package google.guava;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SF on 2018/2/28.
 */
public class MapDifferenceDemo {
    public static Map<String, String> baseMap() {
        Map<String, String> baseMap = new HashMap<>();
        baseMap.put("a", "a");
        baseMap.put("b", "b");
        baseMap.put("c", "c");
        baseMap.put("d", "d");
        baseMap.put("e", "e");
        baseMap.put("f", "f");
        baseMap.put("g", "g");
        baseMap.put("h", "h");
        return baseMap;
    }

    public static Map<String, String> compareMap() {
        Map<String, String> compareMap = new HashMap<>();
        compareMap.put("a", "a1");
        compareMap.put("b", "b1");
        compareMap.put("d", "d1");
        compareMap.put("e", "e1");
        compareMap.put("g", "g");
        compareMap.put("h", "h");
        return compareMap;
    }

    public static void main(String[] args) {
        MapDifference<String, String> mapDifference = Maps.difference(baseMap(), compareMap());
        Map<String, MapDifference.ValueDifference<String>> differences = mapDifference.entriesDiffering();

        differences.forEach((k, stringValueDifference) -> System.out.println("key:"+ k + "\tdiff-value:" + stringValueDifference));
    }
}
