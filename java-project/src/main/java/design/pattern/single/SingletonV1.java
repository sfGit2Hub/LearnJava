package design.pattern.single;

/**
 * Created by Administrator on 2019/7/2.
 * 懒汉式  会存在线程安全问题
 */
public class SingletonV1 {
    private static SingletonV1 uniqueSingleton;

    private SingletonV1(){
    }

    public static SingletonV1 getInstance(){
        if (uniqueSingleton == null)
            uniqueSingleton = new SingletonV1();
        return uniqueSingleton;
    }
}
