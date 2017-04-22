package aop;

/**
 * Created by SF on 2017/3/29.
 */
public class AspectInstant {
    private String name;
    private int num;

    @ParameterChange(parameterClass = String.class)
    public void printName(String name) {
        this.setName(name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        AspectInstant instant = new AspectInstant();
        instant.printName("My name");
    }

    public String getName() {
        return name;
    }

    public AspectInstant setName(String name) {
        this.name = name;
        return this;
    }

    public int getNum() {
        return num;
    }

    public AspectInstant setNum(int num) {
        this.num = num;
        return this;
    }
}
