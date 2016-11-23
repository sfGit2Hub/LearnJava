package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 组是括号划分的正则表达式，可以根据某个组的编号来引用某个组
 * A(B(C)D)E
 * 组0是 A(B(C)D)E
 * 组1是 B(C)D
 * 组2是 C
 */
public class Groups {
    static public final String POEM = "Twas brillig, and the slithy tovesn\n" +
            "Did gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" +
            "Beware the Jabberwock, my son,\n" +
            "The jaws that bite, the claws that cathch.n" +
            "Beware the Jubjjub bird, and shun.";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        while (m.find()) {
            for (int i=0; i<m.groupCount(); i++) {
                System.out.print("[" + m.group(i) + "]");
            }
            System.out.println();
        }
    }
}
