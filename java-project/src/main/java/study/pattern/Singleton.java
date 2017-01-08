package study.pattern;

/**
 * Created by SF on 2017/1/3.
 */
public class Singleton {
    private Singleton() {
    }
    private volatile static Singleton singleton = null;

    public static synchronized Singleton getInstance() {
        if (singleton == null)
            singleton = new Singleton();
        return singleton;
    }
}
