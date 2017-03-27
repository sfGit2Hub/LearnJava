package study.thread;

import common.use.Person;

/**
 * Created by SF on 2017/3/17.
 */
public class ParameterThread{
    public static void main(String []args) {
        Person person = new Person().setAge(20).setID("123456").setName("abel");

        System.out.println(person);

        new Thread(() -> {
            person.setID("55555").setName("change");
            System.out.println(person);
        }).start();

    }
}
