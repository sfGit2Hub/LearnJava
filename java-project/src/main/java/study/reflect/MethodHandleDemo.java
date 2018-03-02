package study.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * Created by SF on 2017/12/19.
 */
public class MethodHandleDemo {
    static class TestClass{
        public void println(String s) {
            System.out.println("TestClass: " + s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object object = System.currentTimeMillis() % 2 == 0 ? System.out : new TestClass();
        getPrintlnMethod(object).invokeWithArguments("hello");
        Method method = object.getClass().getMethod("println", String.class);
        if (method != null) {
            System.out.println(method.getDeclaringClass().getName());
        }
    }

    private static MethodHandle getPrintlnMethod(Object object) throws NoSuchMethodException, IllegalAccessException {
        // MethodType：代表“方法类型”，包含了方法的返回值（methodType()的第一个参数）和具体参数（methodType()第二个及以后的参数）。
        MethodType mt = MethodType.methodType(void.class, String.class);

        // lookup()方法来自于MethodHandles.lookup，这句的作用是在指定类中查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄。
        // 因为这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数是隐式的，代表该方法的接收者，也即是this指向的对象，
        // 这个参数以前是放在参数列表中进行传递，现在提供了bindTo()方法来完成这件事情。
        return MethodHandles.lookup().findVirtual(object.getClass(), "println", mt).bindTo(object);
    }
}
