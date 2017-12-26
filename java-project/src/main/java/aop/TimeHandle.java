package aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SF on 2017/12/15.
 */
public class TimeHandle implements InvocationHandle {
    private Object target;

    public TimeHandle(Object target) {
        super();
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m, Object... args) {
        System.out.println("Execute method start time: " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        try {
            if (args.length > 0) {
                m.invoke(target, args);
            } else {
                m.invoke(target);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("Execute method over time: " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
