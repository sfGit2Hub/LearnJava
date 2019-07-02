package design.pattern.single;

/**
 * Created by Administrator on 2019/7/2.
 * getInstance 方法内加锁判断
 */
public class SingletonV3 {
    private static SingletonV3 uniqueSingleton = null;

    private SingletonV3(){
    }

    public static SingletonV3 getInstance(){
        if (uniqueSingleton == null){
            //只有在为null的时候再加锁，会减少很多性能损耗
            synchronized (SingletonV3.class){
                uniqueSingleton = new SingletonV3();
            }
        }
        return uniqueSingleton;
    }
}
