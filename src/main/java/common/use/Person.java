package common.use;

import java.io.Serializable;

/**
 * Created by SF on 2016/12/25.
 */
public class Person implements Serializable{
    private String name;
    private String ID;
    private int age;
    private Sex sex;

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

    @Override
    public String toString() {
        return "name: " + this.name +"\tage: " + this.age + "\tID: " + this.ID + "\tsex: " + this.sex;
    }
}
