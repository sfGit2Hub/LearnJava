package study.thread;

/**
 * Created by SF on 2016/12/30.
 * 继承 Thread 类创建自己的类来实现多线程
 */
public class ExtendThread extends Thread {
    public ExtendThread() {
        super();
    }

    public ExtendThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread  " + getName() + "- index: " + i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExtendThread thread_1 = new ExtendThread("A");
        ExtendThread thread_2 = new ExtendThread("B");

        thread_1.start();
//        此线程还没执行完，又调用start()方法会抛出 IllegalThreadStateException
//        star()方法会保证方法同步 synchronized
//        thread_1.start();
        thread_2.start();

        thread_1.run();

    }
}
