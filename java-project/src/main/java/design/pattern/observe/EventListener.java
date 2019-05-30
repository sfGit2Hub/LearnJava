package design.pattern.observe;

/**
 * 事件监听器，模拟观察者
 * Created by Administrator on 2019/5/30.
 */
public class EventListener implements Listener {
    public static String className = EventListener.class.getName();

    @Override
    public void handleAction(ActionEvent actionEvent) {
        System.out.println(className + " \thandleAction: " + actionEvent.getActionCommand());
    }
}
