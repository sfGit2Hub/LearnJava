package lintcode;

/**
 * Created by SF on 2018/5/22.
 */
public class 丑数2 {
    /**
     * 我们把只包含因子2、3和5的数称作丑数（Ugly Number）。
     * 求按从小到大的顺序的第1500个丑数。
     * 例如6、8都是丑数，但14不是，因为它包含因子7。
     * 习惯上我们把1当做第一个丑数。
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public static int nthUglyNumber(int n) {
        // write your code here
        int index = 0, num = 0;
        while (index < n) {
            num++;
            int current = num;
            while (current % 2 == 0) {
                current = current / 2;
            }
            while (current % 3 == 0) {
                current = current / 3;
            }
            while (current % 5 == 0) {
                current = current / 5;
            }
            if (current == 1) {
                index ++;
            }
        }
        return num;
    }


    private static int Min(int num1, int num2, int num3)
    {
        int min = num1 < num2 ? num1 : num2;
        min = min < num3 ? min : num3;

        return min;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1652));
    }
}
