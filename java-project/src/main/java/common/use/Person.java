package common.use;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SF on 2016/12/25.
 */
public class Person implements Serializable{
    private String name;
    private String ID;
    private int age;
    private Sex sex;
    private boolean isMarried;
    private Foot rightFoot = new Foot();
    private Foot leftFoot = new Foot();
    private List<String> titles;

    public Foot getRightFoot() {
        return rightFoot;
    }

    public Person setRightFoot(Foot rightFoot) {
        this.rightFoot = rightFoot;
        return this;
    }

    public Foot getLeftFoot() {
        return leftFoot;
    }

    public Person setLeftFoot(Foot leftFoot) {
        this.leftFoot = leftFoot;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getID() {
        return ID;
    }

    public Person setID(String ID) {
        this.ID = ID;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public Person setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public Person setMarried(boolean married) {
        isMarried = married;
        return this;
    }

    public List<String> getTitles() {
        return titles;
    }

    public Person setTitles(List<String> titles) {
        this.titles = titles;
        return this;
    }
//    @Override
//    public String toString() {
//        return MoreObjects.toStringHelper(this)
//                .add("name", name)
//                .add("ID", ID)
//                .add("age", age)
//                .add("sex", sex)
//                .add("isMarried", isMarried)
//                .add("rightFoot", rightFoot)
//                .add("leftFoot", leftFoot)
//                .toString();
//    }
}
