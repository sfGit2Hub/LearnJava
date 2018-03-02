package common.use;

/**
 * Created by SF on 2017/6/23.
 */
public class Adults extends Person {
    public static void main(String[] args) {
        for (int a = 0; a < 100; a++) {
            System.out.println("a:" + a + "\t个位数：" + (a%10) + "\t十位数：" + (a/10));
        }
    }
}
