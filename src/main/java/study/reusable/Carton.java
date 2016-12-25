package study.reusable;

/**
 * Created by SF on 2016/4/13.
 */
public class Carton extends Drawing {
    public Carton() {
        System.out.println("Carton()\t");
    }

    @Override
    public void extend() {
//        showName();
        System.out.println("Carton.extend()\t");
        super.extend();
    }

    public static void testExtendClassName(Art art){
        System.out.println(art.getClass().getName());
        //传入的为Art子类的时候，实际相当于传入了一个子类的引用
    }

    public static void main(String[] args) {
        Carton carton = new Carton();
        carton.extend();
        Drawing drawing = new Drawing("pic");
        drawing.extend();
        drawing.showName();
        testExtendClassName(carton);
        testExtendClassName(drawing);
    }
}
