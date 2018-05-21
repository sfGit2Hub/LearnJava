package lintcode;

/**
 * Created by SF on 2018/5/21.
 */
public class 尾部的零 {
    /*
    * @param n: An integer
    * @return: An integer, denote the number of trailing zeros in n!
    */
    public static long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long numZero = 0;
        while (n/5 > 0) {
            numZero += n/5;
            n = n/5;
        }
        return numZero;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long numZero = trailingZeros(105);
        long end = System.currentTimeMillis();
        System.out.println(numZero);
        System.out.println("Time:" + (start - end));

        System.out.println(1/5);
    }
}
