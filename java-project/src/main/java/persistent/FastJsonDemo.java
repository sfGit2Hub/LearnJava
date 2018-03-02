package persistent;

import com.alibaba.fastjson.JSONPath;
import common.use.Foot;
import common.use.Person;
import common.use.Sex;
import common.use.Toe;

import java.util.Arrays;

/**
 * Created by SF on 2018/3/2.
 */
public class FastJsonDemo {
    private static Person person;
    static {
        person = new Person();
        Foot rightFoot = new Foot(50.2, 20.0, 25.0);
        Foot leftFoot = new Foot(50.1, 19.8, 25.0);
        Toe[] leftToes = new Toe[]{ new Toe("1"), new Toe("2"), new Toe("3"), new Toe("4"), new Toe("5")};
        Toe[] rightToes = new Toe[]{ new Toe("1"), new Toe("2"), new Toe("3"), new Toe("4"), new Toe("5")};
//        leftFoot.setToes(Arrays.asList(leftToes));
        rightFoot.setToes(Arrays.asList(rightToes));
        person.setMarried(false).setName("abel")
                .setID("740j92lJU0&n3b#nfas")
                .setAge(20)
                .setLeftFoot(leftFoot)
                .setRightFoot(rightFoot)
                .setSex(Sex.MALE);
    }


    public static void main(String[] args) {
        JSONPath.eval(person, "leftFoot.length");
        Toe toe = new Toe("aaa");
        JSONPath.set(person, "leftFoot.toes.0", toe);
        System.out.println(person);
    }
}
