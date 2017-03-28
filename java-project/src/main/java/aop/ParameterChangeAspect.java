package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by SF on 2017/3/28.
 */
@Aspect
public class ParameterChangeAspect {
    @Around(value = "@annotation(parameterChange)")
    public Object parameterChangePoint(ProceedingJoinPoint joinPoint, ParameterChange parameterChange) {
        Object obj = null;
        return obj;
    }
}
