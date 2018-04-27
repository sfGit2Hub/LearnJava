package database.redis;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SF on 2018/4/18.
 */
public class DistriLockDemo {
    static ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        service.execute(new DemoTask());
        service.execute(new DemoTask());
        service.execute(new DemoTask());
        service.execute(new DemoTask());
        service.shutdown();
//        Thread thread = new Thread(new DemoTask());
//        Thread thread1 = new Thread(new DemoTask());
//        Thread thread2 = new Thread(new DemoTask());
//        thread.start();
//        thread1.start();
//        thread2.start();
    }

    static class DemoTask implements Runnable, Callable<Integer> {
        RedisDistLock lock = new RedisDistLock(JedisUtils.getClient(), "lock:key", 5000L, 1000L);

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            try {
                if (lock.acquire()) {
                    System.out.println(Thread.currentThread().getName() + " Execute task ...");
                    Thread.sleep(100L);
                } else {
                    System.out.println(Thread.currentThread().getName() + " wait...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " Execute finished! Release the lock");
                lock.release();
            }
            System.out.println("Execute cost time: " + (System.currentTimeMillis() - start));
        }

        @Override
        public Integer call() throws Exception {
            return null;
        }
    }
}
