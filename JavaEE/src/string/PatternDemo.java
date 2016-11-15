package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SF on 2016/5/21.
 * Pattern 与 Matcher 一般同时使用
 * Pattern.compile()解析一段正则表达式字符串
 * Pattern this.matcher(String string) return Matcher
 *
 * Pattern.matches(String regex, CharSequence input) return boolean
 * 传入一个正则表达式
 */
public class PatternDemo {
    private static String s = "abcabcabcdefabc";
    private static String email = "sf_work@foxmail.com";
    private static String[] regexs = {"abc+","(abc)+","(abc){2,}"};
    private static String regexEmail = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    public static void main(String[] args) {
        for (String regex : regexs) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                System.out.println("Now regex is " +"\""+ regex +"\"");
                System.out.println("Match \"" + matcher.group() + "\" at positions " +
                matcher.start() + "-" + (matcher.end() -1));
            }
            boolean emailExe = Pattern.matches(regexEmail, email);
            System.out.println(emailExe);
        }
    }
}
