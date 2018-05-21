package study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by SF on 2018/5/16.
 */
public class ABA问题 {
    private static AtomicInteger atomicInt = new AtomicInteger(0);
    private static AtomicStampedReference<Integer> atomicStampInt = new AtomicStampedReference<>(0, 0);

    public static void main(String[] args) throws InterruptedException {
        Thread int1 = new Thread(() -> {
            atomicInt.compareAndSet(0, 1);
            atomicInt.compareAndSet(1, 0);
        });

        Thread int2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean s = atomicInt.compareAndSet(0, 1);
            System.out.println("CAS设置结果:" + s);
        });

        int1.start();
        int2.start();
        int1.join();
        int2.join();

        Thread refT1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampInt.compareAndSet(atomicStampInt.getReference(), atomicStampInt.getReference() + 1, atomicStampInt.getStamp(), atomicStampInt.getStamp() + 1);
            atomicStampInt.compareAndSet(1, 0, atomicStampInt.getStamp(), atomicStampInt.getStamp() + 1);
            System.out.println("设置完后版本号:" + atomicStampInt.getStamp());
        });

        Thread refT2 = new Thread(() -> {
            int stamp = atomicStampInt.getStamp();
            System.out.println("before sleep : stamp = " + stamp);    // stamp = 0
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after sleep : stamp = " + atomicStampInt.getStamp());   //stamp = 1
            boolean c3 = atomicStampInt.compareAndSet(0, 1, stamp, stamp+1);
//            boolean c3 = atomicStampInt.compareAndSet(
//                    atomicStampInt.getReference(),
//                    atomicStampInt.getReference() + 1,
//                    atomicStampInt.getStamp(),
//                    atomicStampInt.getStamp() + 1);
            System.out.println("乐观锁+CAS设置结果:" + c3);        //false
        });

        refT1.start();
        refT2.start();
    }

}
