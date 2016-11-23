package operator;

/**
 * Created by SF on 2016/3/25.
 */
public class Fibonacci {
    public static int finonacci(int i) {
        if ( i <= 0) return 0;
        if ( i < 3) return 1;
        return finonacci(i-1) + finonacci(i-2);
    }
}
