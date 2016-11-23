package string;

import java.math.BigInteger;
import java.util.Formatter;

/**
 * Created by SF on 2016/5/19.
 *
 * Formatter 最常用的类型转换
 */
public class Conversion {
    /**
     *   d      整数型(十进制）    ||      e   浮点数（科学计数）
     *   c      Unicode字符      ||      x   整数（十六进制）
     *   b      Boolean 值       ||      h   散列码（十六进制）
     *   s      String          ||      %   字符%
     *   f      浮点数（十进制）    ||
     */
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);

        char u = 'a';
        System.out.println("u = ‘a’");
        f.format("s-字符串: %s\n", u);
//        f.format("d-整数十进制: %d\n", u);
        f.format("c-Unicode字符: %c\n", u);
        f.format("b-Boolean值: %b\n", u);
        f.format("h-散列码（十六进制）: %h\n", u);
        System.out.println("---------------");

        int v=121;
        System.out.println("v = 121");
        f.format("d-整数十进制: %d\n", v);
        f.format("c-Unicode字符: %c\n", v);
        f.format("b-Boolean值: %b\n", v);
        f.format("s-字符串: %s\n", v);
//        f.format("f-浮点数（十进制）: %d\n", v);
//        f.format("e-浮点数（科学计数）: %e\n", v);
        f.format("h-散列码: %h\n", v);
        f.format("x-整数十六进制: %x\n", v);
        System.out.println("----------------");

        BigInteger w = new BigInteger("5000000000000");
        System.out.println("w = new BigInteger(\"5000000000000\")");
        f.format("d-整数十进制: %d\n", w);
//        f.format("c-Unicode字符: %c\n", w);
        f.format("b-Boolean: %b\n", w);
        f.format("s-字符串: %s\n", w);
//        f.format("f: %d\n", w);
//        f.format("e-浮点数（科学计数）: %d\n", w);
        f.format("h-散列码十六进制: %h\n", w);
        f.format("x-整数十六进制: %x\n", w);
        System.out.println("----------------");

        double x = 13.45;
        System.out.println("x = 13.45");
//        f.format("d-整数十进制: %d\n", x);
//        f.format("c-Unicode字符: %c\n", x);
        f.format("b-Boolean: %b\n", x);
        f.format("s-字符串: %s\n", x);
        f.format("f: %f\n", x);
        f.format("e-浮点数（科学计数）: %e\n", x);
        f.format("h-散列码十六进制: %h\n", x);
//        f.format("x-整数十六进制: %x\n", x);
        System.out.println("----------------");
    }

}
