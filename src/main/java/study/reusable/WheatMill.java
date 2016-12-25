package study.reusable;

/**
 * Created by SF on 2016/4/27.
 */
public class WheatMill extends Mill {
    private String name;

    @Override
    public Drawing testExtendsClass() {
        return new Drawing("Wheat");
    }

    @Override
    public String toString() {
        return "WheatMill{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
