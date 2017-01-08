package study.initial;

/**
 * Created by SF on 2016/4/5.
 */
class Cup{
    Cup(int mark){
        System.out.println("Cup(" + mark +")");
    }

    void f1(int mark){
        System.out.println("f1(" + mark +")");
    }
}

class Cups{
    static Cup c1;
    static Cup c2;
    static {
        c2 = new Cup(2);
        c1 = new Cup(1);
    }

    Cups(int mark) {
        System.out.println("Cups(" + mark +")");
    }

    void f2(int mark) {
        System.out.println("f2(" + mark +")");
    }
}

public class StaticInitial {
    public static void main(String[] args) {
        System.out.println("Start main:");
//        Cups.c1.f1(1);
        Cups cups = new Cups(3);
    }
}
