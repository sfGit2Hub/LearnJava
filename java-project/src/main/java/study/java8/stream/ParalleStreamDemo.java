package study.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SF on 2018/4/12.
 */
public class ParalleStreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.parallelStream().forEach(System.out::println);
    }
}
