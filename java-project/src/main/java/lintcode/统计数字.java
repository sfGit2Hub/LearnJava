package lintcode;

/**
 * Created by SF on 2018/5/21.
 */
public class 统计数字 {
    /**
     计算数字k在0到n中的出现的次数，k可能是0~9的一个值
     样例
     例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
     */
    /**
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public static int digitCounts(int k, int n) {
        int num = 0;
        /*String kChar = k + "";
        for (int i = 0; i <= n; i++) {
            String nStr = i + "";
            while (nStr.contains(kChar)) {
                num++;
                nStr = nStr.substring(nStr.indexOf(kChar) + 1);
            }
        }*/
        for (int i = 0; i <= n; i++) {
            int number = i;
            while (number / 10 > 0) {
                if (number % k == 0) {
                    number++;
                }
                number = number / 10;
            }
            if (number == k) {
                num++;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(digitCounts(10, 10000));

        String t = String.format("aaa %s bbb", 111);
        System.out.println(t);
    }
}
