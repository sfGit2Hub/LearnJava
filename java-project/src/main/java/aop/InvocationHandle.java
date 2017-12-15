package aop;

import java.lang.reflect.Method;

/**
 * Created by SF on 2017/12/15.
 */
public interface InvocationHandle {
    public void invoke(Object o, Method m);
}
