package lintcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz问题 {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public static List<String> fizzBuzz(int n) {
        // write your code here
        String fizz = "fizz", buzz = "buzz", fizzBuzz = "fizz buzz";
        List<String> results = new ArrayList<>();
        for (int i = 1; i<= n; i++) {
            String temp;
            if (i % 15 == 0) {
                temp = fizzBuzz;
            } else if (i % 3 == 0) {
                temp = fizz;
            } else if (i % 5 == 0) {
                temp = buzz;
            } else {
                temp = Integer.toString(i);
            }
            results.add(temp);
        }
        return results;
    }
}
