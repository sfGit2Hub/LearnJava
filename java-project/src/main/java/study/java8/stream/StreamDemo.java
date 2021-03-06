package study.java8.stream;

import common.use.Person;
import common.use.Sex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by SF on 2016/7/13.
 */
public class StreamDemo {
    public static void buildStream(){
        Stream<Integer> integerStream = Stream.of(1, 2, 8, 6, 4);
        Stream.generate(new Supplier<Integer>() {
            private int i =0;
            @Override
            public Integer get() {
                return i++;
            }
        });
        Stream.generate(Math::random);
        Stream.iterate("a", item -> item+"|").limit(5).forEach(System.out::println);
    }

    public static void useFunction(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "a", "b", "c","a", "aa", "ab", "cc", "bb", "bc");
        list.stream().filter(e -> e.length()>=2).forEach(e -> System.out.print(e + ","));
        List list1 = list.stream().distinct().collect(Collectors.toList());
        List<Integer> integerList = Arrays.asList(1, 2, 3, 8, 9, 6, 4, 2, 3, 7, 6);
        integerList.stream().map(var -> {
            var++;
            var += 2;
            return var;
        });
        Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .forEach(integers -> System.out.print(integers + "-"));

        List<Integer> together = Stream.of(Arrays.asList(1, 2),Arrays.asList(3, 4))
                .flatMap(Collection::stream).collect(Collectors.toList());
        list.stream().distinct().peek(e -> System.out.println(e.length())).count();
        System.out.println(together);
        System.out.println(list);
    }

    public static void generateData() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person().setAge(21).setName("a").setSex(Sex.FEMALE));
        persons.add(new Person().setAge(10).setName("b").setSex(Sex.FEMALE));
        persons.add(new Person().setAge(18).setName("c").setSex(Sex.MALE));
        persons.add(new Person().setAge(22).setName("d").setSex(Sex.MALE));
        String name = null;
        System.out.println("=============================");
//        filter 条件不可为null 否则报错
        persons.stream().filter(person -> person.getName().contains(name))
                .filter(person -> person.getAge() > 20)
                .forEach(person -> System.out.println(person));
//        一个流只能被执行一次
    }

    public static void main(String []args){
        useFunction();
        generateData();

    }
}
