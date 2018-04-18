package database.redis;

/**
 * Created by SF on 2018/4/18.
 */
public class DistriLockDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new DemoTask());
        Thread thread1 = new Thread(new DemoTask());
        Thread thread2 = new Thread(new DemoTask());
        thread.start();
        thread1.start();
        thread2.start();
    }

    static class DemoTask implements Runnable {
        RedisDistLock lock = new RedisDistLock(JedisUtils.getClient(), "lock:key", 5000L, 1000L);
        @Override
        public void run() {
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
        }
    }
}
