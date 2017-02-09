package study.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionThread {

    public static void synchronizedCollection() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        List synchrList = Collections.synchronizedList(list);
        synchrList.forEach(o -> System.out.println(o));
    }

    public static void main(String []args) {
        synchronizedCollection();
    }
}
