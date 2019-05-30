package design.pattern.observe;

import java.util.Date;

/**
 * 模拟鼠标点击事件
 * Created by Administrator on 2019/5/30.
 */
public class ClickEvent implements ActionEvent {

    @Override
    public String getActionCommand() {
        return "Click Event";
    }

    public Date getClickTime(){
        return new Date(System.currentTimeMillis());
    }
}
