package reusable;

/**
 * Created by SF on 2016/4/13.
 */
public class Drawing extends Art{
    public Drawing() {
        System.out.println("Drawing()\t");
    }

    public Drawing(String name) {
        super(name);
        System.out.println("Drawing(" + name + ")\t");
    }



    @Override
    public void extend() {
        System.out.println("Drawing.extend()\t");
    }

//    @Override
//    protected void showName() {
//        super.showName();
//    }
}
