package study.string;

import java.util.Random;

/**
 * Created by SF on 2016/5/19.
 *
 * 主要用来比较StringBuilder 和 StringBuffered 拼接字符串的效率
 */
public class BuilderAndBuffer {
    private static Random random = new Random(47);

    public static String BuilderToString() {
        Long startTime = System.currentTimeMillis();
        StringBuilder sBuilder = new StringBuilder();
        for (int i=0; i<100000; i++) {
            sBuilder.append(random.nextInt());
        }
        String result = sBuilder.toString();
        Long endTime = System.currentTimeMillis();
        System.out.println("StringBuilder:" + (endTime-startTime));
        return result;
    }

    public static String BufferedToString() {
        Long startTime = System.currentTimeMillis();
        StringBuffer sBuffer = new StringBuffer();
        for (int i=0; i<100000; i++) {
            sBuffer.append(random.nextInt());
        }
        String result = sBuffer.toString();
        Long endTime = System.currentTimeMillis();
        System.out.println("StringBuffered:" + (endTime-startTime));
        return result;
    }

    public static void main(String[] args) {
        BufferedToString();
        BuilderToString();
        String url = "https://www.cloudfront.net/dev/dsone/2A233F6AC72D400B92D7B541073016AD/roomType/20170113172947549.png";
        int index = url.lastIndexOf(".");
        String newUrl = url.substring(0, index) + "_s" + url.substring(index);
        System.out.println(newUrl);
    }
}
