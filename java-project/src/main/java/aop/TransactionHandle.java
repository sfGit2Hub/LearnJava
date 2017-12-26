package aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by SF on 2017/12/15.
 */
public class TransactionHandle implements InvocationHandle {
    private Object target;

    public TransactionHandle(Object target) {
        super();
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m, Object... args) {
        System.out.println("Open transaction......");
        ParameterChange annotation = o.getClass().getAnnotation(ParameterChange.class);
        if (annotation != null) {
            System.out.println("Transaction -- index: " + annotation.parameterIndex());
        }
        try {
            m.invoke(target, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Commit transaction......");
    }
}
