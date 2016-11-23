package reusable;

/**
 * Created by SF on 2016/4/13.
 */
public class Art {
    private String name;

    public Art() {
        System.out.println("Art()" + "\t");
    }

    public Art(String name) {
        this.name = name;
        System.out.println("Art(" + name + ")\t");
    }

    public void extend() {
        System.out.printf("extend()" + "\t");
    }

    protected void showName() {
        extend();
        System.out.println(this.name);
    }


}
