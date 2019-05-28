package design.pattern.observe;

/**
 * Created by Administrator on 2019/5/28.
 */
public interface Subject<T> {
    void registerObserver(T observe);
    void removeObserver(T observe);
    void notifyObservers();
}
