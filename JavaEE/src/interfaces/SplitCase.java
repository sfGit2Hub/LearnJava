package interfaces;

import java.util.Arrays;

/**
 * Created by SF on 2016/4/28.
 */
public class SplitCase extends StringProcess {
    @Override
    public String process(Object input) {
        if (input instanceof String)
            return Arrays.toString(((String) input).split(" "));
        return null;
    }
}
