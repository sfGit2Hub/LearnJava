package study.collections;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/12/20.
 */
public class CircleQueueTest {
    public static void main(String[] args) {
        System.out.println(output(10, 1));
    }

    public static Integer[] output(int length, int step) {
        int[] result;
        long initStartTime = System.currentTimeMillis();
        CircleLinkList<Integer> circle = new CircleLinkList<>(length);
        for (int i=1; i<=length; i++) {
            circle.add(i);
        }
        System.out.println("Initial over! Use time:" + (System.currentTimeMillis() - initStartTime));

        Iterator iterator = circle.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }
        return circle.getResult();
    }
}
