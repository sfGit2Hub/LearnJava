package reusable;

/**
 * Created by SF on 2016/4/15.
 */
public class Value {
    int i;
    public Value(int i){
        this.i = i;
    }

    @Override
    public String toString() {
        return "Value : i=" + this.i;
    }
}
