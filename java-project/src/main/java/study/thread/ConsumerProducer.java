package study.thread;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2018/1/16.
 */
public class ConsumerProducer {
    static class Producer extends Thread {
        private Queue<Integer> queue;
        private int maxSize;

        public Producer(Queue<Integer> queue, int maxSize, String name) {
            super(name);
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == maxSize) {   //当缓存区满的时候
                        try {
                            //进入wait
                            System.out.println("Queue is full, Producer thread waiting for consumer to take something from queue");
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    //缓存区不为空的时候就可以继续生产，生产后唤醒消费者线程的wait
                    Random random = new Random();
                    int i = random.nextInt();
                    System.out.println("Producing value : " + i);
                    queue.add(i);
                    queue.notifyAll();
                }
            }
        }
    }

    static class Consumer extends Thread {
        private Queue<Integer> queue;
        private int maxSize;
        public Consumer(Queue<Integer> queue, int maxSize, String name){
            super(name);
            this.queue = queue;
            this.maxSize = maxSize;
        }
        @Override public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        System.out.println("Queue is empty,Consumer thread is waiting for producer thread to put something in queue");
                        try {
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("Consuming value : " + queue.remove());
                    queue.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        Producer producer = new Producer(queue, 10, "producer-thread");
        Consumer consumer = new Consumer(queue, 10, "consumer-thread");
        producer.start();
        consumer.start();
    }
}
