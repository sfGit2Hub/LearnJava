package study.interfaces;

/**
 * Created by SF on 2016/4/28.
 */
public class WaveForm {
    private static long count;
    private final long id = count++;

    @Override
    public String toString() {
        return "Wave-" + id;
    }
}
