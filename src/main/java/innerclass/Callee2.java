package innerclass;

/**
 * Created by SF on 2016/5/4.
 */
public class Callee2 extends MyIncrement {
    private int i=0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println("Callee2-i:" + i);
    }

    private class Closure implements Incrementable{
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    public Incrementable getCallbackReference(){
        return new Closure();
    }
}
