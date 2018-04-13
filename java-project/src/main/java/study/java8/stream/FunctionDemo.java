package study.java8.stream;

import com.alibaba.fastjson.JSON;
import common.use.Person;
import common.use.Sex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by SF on 2018/4/13.
 */
public class FunctionDemo {
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new HashMap<>();
        return object -> seen.putIfAbsent(keyExtractor.apply(object), Boolean.TRUE) == null;
    }

    public static List<Person> distinct(List<Person> persons) {
        return persons.parallelStream()
                .filter(distinctByKey(Person::getName))
                .collect(Collectors.toList());
    }

    public static Map<Sex, List<Person>> groupBySex(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(person -> {
            if (person.getSex().equals(Sex.FEMALE))
                return Sex.FEMALE;
            else
                return Sex.MALE;
        }));
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("1", "id-1", Sex.MALE));
        persons.add(new Person("1", "id-2", Sex.FEMALE));
        persons.add(new Person("1", "id-3", Sex.FEMALE));
        persons.add(new Person("1", "id-4", Sex.FEMALE));
        persons.add(new Person("1", "id-5", Sex.FEMALE));
        persons.add(new Person("2", "id-6", Sex.MALE));
        persons.add(new Person("3", "id-5", Sex.FEMALE));

        System.out.println(distinct(persons));
        System.out.println(JSON.toJSONString(groupBySex(persons)));
    }
}
