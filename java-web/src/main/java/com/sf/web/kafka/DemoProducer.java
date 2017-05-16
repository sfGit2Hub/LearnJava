package com.sf.web.kafka;

import com.google.gson.Gson;
import common.use.Person;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by SF on 2017/3/21.
 */
public class DemoProducer {
    private static Properties props = new Properties();
    static {
        try {
            props.load(DemoProducer.class.getClassLoader().getResourceAsStream("kafkaProducer.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Producer<String, String> producer = new KafkaProducer<>(props);
        for(int i = 100; i < 200; i++) {
            Person person = new Person().setName("person" + i).setID("ID-" + i).setAge(10);
            producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), new Gson().toJson(person)));
            System.out.println(i);
        }

        producer.close();
    }
}
