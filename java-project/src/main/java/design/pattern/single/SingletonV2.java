package design.pattern.single;

/**
 * Created by Administrator on 2019/7/2.
 * 饿汉式  不会存在线程安全问题
 * 但不是在需要的时候才初始化，内存会一直存在
 */
public class SingletonV2 {
    private static SingletonV2 uniqueSingleton = new SingletonV2();

    private SingletonV2(){
    }

    public static SingletonV2 getInstance(){
        return uniqueSingleton;
    }
}
