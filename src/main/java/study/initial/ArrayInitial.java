package study.initial;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by SF on 2016/4/5.
 */
public class ArrayInitial {
    public static void main(String[] args) {
        Random rand = new Random(47);
        int[] a1 = new int[10];
        for (int i=0; i<10; i++){
            a1[i] = rand.nextInt(100);
        }

        int[] a2 = {
                rand.nextInt(100),
                rand.nextInt(100),
                rand.nextInt(100),
        };

        System.out.println("int[] a1: " + Arrays.toString(a1));
        System.out.println("int[] a2: " + Arrays.toString(a2));
    }
}
