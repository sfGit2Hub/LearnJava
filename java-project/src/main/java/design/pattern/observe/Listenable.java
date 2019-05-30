package design.pattern.observe;

/**
 * 可被监听，相当于主题Subject
 * Created by Administrator on 2019/5/30.
 */
public interface Listenable {
    void addListener(Listener listener);

    void notifyAllListener(ActionEvent actionEvent);

    void notifyListener(Listener listener, ActionEvent actionEvent);
}
