package study.collections;

import common.use.Person;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SF on 2017/1/5.
 */
public class ListChangeable {
    public static void main(String []args) {
        List<Person> persons = new LinkedList<>();
        Person person_1 = new Person().setAge(20).setID("2224342532").setName("Tom");
        Person person_2 = new Person().setAge(18).setID("345230996903").setName("Jack");
        Person person_3 = new Person().setAge(19).setID("156984132478").setName("John");
        persons.add(person_1);
        persons.add(person_2);
        persons.add(person_3);
//        person_1.setAge(21);
        persons.get(0).setAge(21);
        persons.forEach(person -> System.out.println(person));
    }
}
