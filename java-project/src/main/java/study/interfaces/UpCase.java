package study.interfaces;

/**
 * Created by SF on 2016/4/28.
 */
public class UpCase extends StringProcess {
    @Override
    public String process(Object input) {
        if (input instanceof String)
            return ((String)input).toUpperCase();
        return null;
    }
}
