package study.type;

/**
 * Created by SF on 2016/10/17.
 */
public class CounterInteger {
    private static long counter;
    private final long id = counter++;
    public String toString() {
        return Long.toString(id);
    }
}
