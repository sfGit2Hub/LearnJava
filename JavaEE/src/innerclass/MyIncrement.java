package innerclass;

/**
 * Created by SF on 2016/5/4.
 */
public class MyIncrement {
    public void increment(){
        System.out.println("Other operation");
    }

    public static void f(MyIncrement mi){
        mi.increment();
    }
}
