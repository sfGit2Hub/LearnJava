package hackday.shifeng;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TestCase {
    private static Map<String, String> TestCase = new HashMap<>();

    static {
        TestCase.put(null, null);
        TestCase.put("", "");
        TestCase.put("1", "1");
        TestCase.put("2", "2");
        TestCase.put("3", "3");
        TestCase.put("12", "3");
        TestCase.put("13", "2");
        TestCase.put("23", "1");
        TestCase.put("21", "3");
        TestCase.put("31", "2");
        TestCase.put("32", "1");
        TestCase.put("11", "1");
        TestCase.put("22", "2");
        TestCase.put("33", "3");
        TestCase.put("1133", "2");
        TestCase.put("1122", "3");
        TestCase.put("3311", "2");
        TestCase.put("3211", "2");
        TestCase.put("3212", "1");
        TestCase.put("31321", "1");
        TestCase.put("12332", "2");
        TestCase.put("11223", "1");
        TestCase.put("33223", "2");
        TestCase.put("2221213322233211313312321221222231331232313323133211322332222131212123132333132222332111133212333122", "2");
        TestCase.put("1111111111111111111111111111111111111111111111111111", "1");

    }

    public static void main(String[] args) {
        ShifengDigitalPredictorImp predictor = new ShifengDigitalPredictorImp();
        for (Map.Entry<String, String> entry : TestCase.entrySet()){
            String result = predictor.predict(entry.getKey());
            if (entry.getKey() == null) {
                if (result != null) {
                    System.out.println(entry.getKey() + "  Supposed: " + entry.getValue() + "\tYour: " + result);
                    continue;
                }
                continue;
            }
            if (!entry.getValue().equals(result)) {
                System.out.println(entry.getKey() + "  Supposed: " + entry.getValue() + "\tYour: " + result);
            }
        }
        long start = System.currentTimeMillis();
        String test = readByFile("E:\\usr\\local\\test.txt");
        long end = System.currentTimeMillis();
        System.out.println(predictor.predict(test));
        System.out.println("Cost Time: " + (end - start));
    }

    private static String readByFile(String path) {
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader(path));
            String input = null;
            StringBuilder builder = new StringBuilder();
            while ((input = rd.readLine()) != null) {
                builder.append(input);
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                rd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
