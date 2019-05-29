package design.pattern.observe;

/**
 * Created by Administrator on 2019/5/28.
 */
public interface Observe {
    void update(Subject subject);
    void update(Subject subject, Object arg);
}
