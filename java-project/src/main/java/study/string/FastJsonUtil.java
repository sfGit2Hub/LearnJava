package study.string;

import com.alibaba.fastjson.JSON;
import common.use.Person;

/**
 * Created by SF on 2017/2/22.
 */
public class FastJsonUtil {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(20)
                .setName("abel")
                .setID("1222222")
                .setMarried(true);
        String personStr = JSON.toJSONString(person);
        System.out.println(personStr);
    }
}
