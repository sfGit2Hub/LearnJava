package innerclass;

/**
 * Created by SF on 2016/5/4.
 */
public class Caller {
    private Incrementable callbackReference;
    public Caller(Incrementable incrementable){
        callbackReference = incrementable;
    }

    public void go(){
        callbackReference.increment();
    }
}
