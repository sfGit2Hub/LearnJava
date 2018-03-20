package study.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SF on 2016/5/21.
 * Pattern 与 Matcher 一般同时使用
 * Pattern.compile()解析一段正则表达式字符串
 * Pattern this.matcher(String study.string) return Matcher
 *
 * Pattern.matches(String regex, CharSequence input) return boolean
 * 传入一个正则表达式
 */
public class PatternDemo {
    private static String s = "abcabcabcdefabc (Test)";
    private static String email = "sf_work@foxmail.com";
    private static String[] regexs = {"abc+","(abc)+","(abc){2,}"};
    private static String regexEmail = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    private static String ignoreCase = "(t|T)(e|E)(s|S)(t|T)";
    public static void main(String[] args) throws ParseException {
        Pattern testPattern = Pattern.compile("测试", Pattern.CASE_INSENSITIVE);
        Matcher testMatcher = testPattern.matcher("测试用 hotel");

        System.out.println("ignore case result:" + testMatcher.find());
        System.out.println("replace \"test\" result:" + "TEst hotel".replaceAll(ignoreCase, "aaa"));
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

        testNumIndex();

        testDateMonth();
    }

    public static void testNumIndex() {
        String key = "aaa.2.bbb.3.ga";
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(key);
        String value = "a-test.*.b-test.*.ga";
        while (m.find()) {
            String arrayIndex = m.group();
            if (value != null) {
                value = value.replaceFirst("\\*", arrayIndex);
                continue;
            }
        }
        System.out.println(value);
    }

    public static void testDateMonth() throws ParseException {
        String textDate = "03 1 2018";
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.JAPAN);
        Date date = format.parse(textDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM", Locale.UK);
        System.out.println(dateFormat.format(date));
    }
}
