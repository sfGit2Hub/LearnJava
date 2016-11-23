package innerclass;

/**
 * Created by SF on 2016/5/4.
 */
public class Callee1 implements Incrementable {
    private int i=0;
    @Override
    public void increment() {
        i++;
        System.out.println("Callee1-i:"+i);
    }
}
