package com.sf.web.kafka;

import com.google.gson.Gson;
import common.use.Person;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by SF on 2017/3/21.
 */
public class DemoConsumer {
    private static Properties props;
    static {
        props = new Properties();
        try {
            props.load(DemoProducer.class.getClassLoader().getResourceAsStream("kafkaConsumer.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String []args) {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                Person person = new Gson().fromJson(record.value(), Person.class);
                System.out.println(person);
            }
        }
    }
}
