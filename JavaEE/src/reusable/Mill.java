package reusable;

/**
 * Created by SF on 2016/4/27.
 */
public class Mill {
    private String name;

    public Art testExtendsClass(){
        return new Art("Mill");
    }

    @Override
    public String toString() {
        return "Mill{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
