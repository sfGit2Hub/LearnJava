package design.pattern.observe;

/**
 * Created by Administrator on 2019/5/30.
 */
public class ClickEventListener implements Listener {
    public static String ClassName = ClickEventListener.class.getName();

    @Override
    public void handleAction(ActionEvent actionEvent) {
        if (actionEvent != null){
            System.out.println(ClassName + " \thandleAction: " + actionEvent.getActionCommand());
            if (actionEvent instanceof ClickEvent){
                ClickEvent clickEvent = (ClickEvent) actionEvent;
                System.out.println(ClassName + " \tClickTime: " + clickEvent.getClickTime());
            }
        }
    }
}
