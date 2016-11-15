package interfaces;

/**
 * Created by SF on 2016/4/28.
 */
public class LowerCase extends StringProcess {
    @Override
    public String process(Object input) {
        if (input instanceof String)
            return ((String)input).toLowerCase();
        return null;
    }
}
