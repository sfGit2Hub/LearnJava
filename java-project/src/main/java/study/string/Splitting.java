package study.string;

import java.util.Arrays;

/**
 * Created by SF on 2016/5/19.
 *
 * String.split(String regex)  将字符串从正则表达式匹配的地方切开
 * String.replaceFirst(String regex， String new) 用一个字符串替换第一个匹配正则表达式的地方
 */
public class Splitting {
    public static String knights = "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest... " +
            "with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void replace(String regex, String newString) {
        System.out.println(knights.replaceAll(regex, newString));
        System.out.println(knights.replaceFirst(regex, newString));
    }

    public static void main(String[] args) {
        String test = "111111";
        System.out.println(test.split(";")[0]);
        split(" ");
        split("\\W+");//一个或多个非单词字符
        split("n\\W+");
    }

}
