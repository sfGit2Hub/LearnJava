package study.io;

/**
 * Created by SF on 2017/11/3.
 */
public class Performance {
    public static void main(String[] args) {
        long start_time = System.currentTimeMillis();
//        for (int i=0; i< 10000*1000; i++) {
//            int j = 0;
//            continue;
//        }
        int i = 0;
        while ( i < 1000*1000) {
            i++;
        }
        long end_time = System.currentTimeMillis();
        System.out.println(end_time - start_time);
    }
}
