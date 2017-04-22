package study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by SF on 2017/4/14.
 */
public class BarWorker implements Runnable {
//    private static boolean exists = false;
//    多线程运行过程中，保证一段操作的原子性
    private static AtomicBoolean exists = new AtomicBoolean(false);
    private String name;

    public BarWorker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
/*        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            // do nothing
            e.printStackTrace();
        }
        if (!exists) {
            exists = true;
            System.out.println(name + "-enter");
            System.out.println(name + "-working");
            System.out.println(name + "-end");
            exists = false;
        } else {
            System.out.println(name + " give up");
        }*/
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            // do nothing
            e.printStackTrace();
        }

        if (exists.compareAndSet(false, true)) {
            System.out.println(name + " enter");
//            try {
                System.out.println(name + " working");
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
                // do nothing
//            }
            System.out.println(name + " leave");
            exists.set(false);
        }else{
            System.out.println(name + " give up");
        }
    }

    public static void main(String[] args) {
        new Thread(new BarWorker("thread-1#")).start();
        new Thread(new BarWorker("thread-2#")).start();
        new Thread(new BarWorker("thread-3#")).start();
        new Thread(new BarWorker("thread-4#")).start();
    }
}
