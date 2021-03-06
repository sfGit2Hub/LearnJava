package common.use;

import com.alibaba.fastjson.JSON;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Date;
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
    private Date birthDay;

    public Person(){}

    public Person(String name, String id, Sex sex) {
        this.name = name;
        this.ID = id;
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public Person setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public Foot getRightFoot() {
        return rightFoot;
    }

    public Person setRightFoot(Foot rightFoot) {
        this.rightFoot = rightFoot;
        return this;
    }

    public Person setRightFoot(String footParams) {
        String[] params = footParams.split(",");
        if (params.length >= 3) {
            this.rightFoot = new Foot(params[0], params[1], params[2]);
        }
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

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
