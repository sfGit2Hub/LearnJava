package com.sf.web.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by SF on 2017/4/12.
 */
public class KafkaConsumerRunner implements Runnable {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final KafkaConsumer consumer;

    public KafkaConsumerRunner(Properties properties) {
        this.consumer = new KafkaConsumer(properties);
    }

    @Override
    public void run() {
        try {
            consumer.subscribe(Arrays.asList("topic"));
            while (!closed.get()) {
                ConsumerRecords<String,String> records = consumer.poll(100);
                // Handle new records
                records.forEach(record -> {
                    String key = record.key();
                    String value = record.value();
                    System.out.println("key:" + key);
                    System.out.println("value:" + value);
                });
            }
        } catch (WakeupException e) {
            // Ignore exception if closing
            if (!closed.get()) throw e;
        } finally {
            consumer.close();
        }
    }

    // Shutdown hook which can be called from a separate thread
    public void shutdown() {
        closed.set(true);
        consumer.wakeup();
    }

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        Properties properties = new Properties();
        properties.load(KafkaConsumerRunner.class.getClassLoader().getResourceAsStream("kafkaConsumer.properties"));
        executorService.submit(new KafkaConsumerRunner(properties));
        executorService.submit(new KafkaConsumerRunner(properties));
        executorService.submit(new KafkaConsumerRunner(properties));
        executorService.submit(new KafkaConsumerRunner(properties));
    }
}
