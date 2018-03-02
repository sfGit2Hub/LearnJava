package cglib;

import com.google.common.collect.Maps;
import common.use.Foot;
import common.use.Person;
import common.use.Sex;
import net.sf.cglib.beans.BeanMap;

import java.util.Map;

/**
 * Created by SF on 2018/3/2.
 */
public class MapObjectConvert {
    public static <T> Map<String,Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }


    public static void main(String[] args) {
        Person person = new Person();
        Foot rightFoot = new Foot(50.2, 20.0, 25.0);
        Foot leftFoot = new Foot(50.1, 19.8, 25.0);
        person.setMarried(false).setName("abel")
                .setID("740j92lJU0&n3b#nfas")
                .setAge(20)
                .setLeftFoot(leftFoot)
                .setRightFoot(rightFoot)
                .setSex(Sex.MALE);

        Map<String, Object> personMap = beanToMap(person);
        for (Map.Entry<String, Object> entry : personMap.entrySet()){
            System.out.println("key:" + entry.getKey());
            System.out.println("value:" + entry.getValue());
        }
    }
}
