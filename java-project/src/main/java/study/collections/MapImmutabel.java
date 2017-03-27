package study.collections;

import common.use.Person;
import study.type.Cat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SF on 2016/12/2.
 */
public class MapImmutabel {
    private int age;
    /**
     * 0- female
     * 1- male
     */
    private int sex;

    private Map<String, String> aliasName;

    private Cat pet;

    public Cat getPet() {
        return pet;
    }

    public void setPet(Cat pet) {
        this.pet = pet;
    }

    public Map<String, String> getAliasName() {
        return aliasName;
    }

    public void setAliasName(Map<String, String> aliasName) {
        this.aliasName = aliasName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("age: ");
        builder.append(this.age + "\n");
        builder.append("sex: ");
        builder.append(this.sex + "\n");
        builder.append("aliasName:\n");
        for (Map.Entry entry : this.aliasName.entrySet()) {
            builder.append("\t" + entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return builder.toString();
    }

    public static void testMap() {
        Map<String, Object> map = new HashMap<>();
        Person person = (Person) map.get("person");
        String str = (String) map.get("string");
        System.out.println(str);
    }

    public static void main(String []args) {
        Map<String, String> aliasName = new HashMap<>();
        aliasName.put("sf", "abel");

        MapImmutabel mapImmutabel = new MapImmutabel();
        mapImmutabel.setAge(20);
        mapImmutabel.setSex(1);
        mapImmutabel.setAliasName(aliasName);

        mapImmutabel.getAliasName().put("gg", "mm");

        System.out.println(mapImmutabel);

        testMap();
    }
}
