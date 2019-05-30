package design.pattern.observe;

/**
 * 模拟鼠标操作
 * Created by Administrator on 2019/5/30.
 */
public class Mouse {
    public void ClickButton(Button button){
        button.notifyAllListener(new ClickEvent());
    }
}
