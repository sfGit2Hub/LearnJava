package study.thread;

/**
 * Created by SF on 2016/12/30.
 * 如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。
 */
public class ImpleThread implements Runnable {
    private String threadName;
    private int count;
    public ImpleThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread-" + this.threadName + " - count:" + count);
            this.count--;
            try {
                Thread.sleep((int)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ImpleThread thread_1 = new ImpleThread("A");
        thread_1.setCount(10);
        ImpleThread thread_2 = new ImpleThread("B");
//        此方式会顺序执行，并没有创建多线程
//        thread_1.run();
//        thread_1.run();
//        thread_2.run();

        new Thread(thread_1).start();
//        new Thread(thread_1).run();
        new Thread(thread_2).start();
    }

    public int getCount() {
        return count;
    }

    public ImpleThread setCount(int count) {
        this.count = count;
        return this;
    }
}
