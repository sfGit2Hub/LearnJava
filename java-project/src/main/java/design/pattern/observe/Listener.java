package design.pattern.observe;

/**
 * 模拟监听器，相当于观察者模式中的观察者
 * Created by Administrator on 2019/5/30.
 */
public interface Listener {
    void handleAction(ActionEvent actionEvent);
}
