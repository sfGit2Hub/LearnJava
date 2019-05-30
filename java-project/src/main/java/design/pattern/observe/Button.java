package design.pattern.observe;

import java.util.Vector;

/**
 * 模拟按钮，可被监听，相当于subject
 * Created by Administrator on 2019/5/30.
 */
public class Button implements Listenable {
    private Vector<Listener> listeners = new Vector<>();

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void notifyAllListener(ActionEvent actionEvent) {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).handleAction(actionEvent);
        }
    }

    @Override
    public void notifyListener(Listener listener, ActionEvent actionEvent) {
        int index = listeners.indexOf(listener);
        if (index < 0) return;
        listeners.get(index).handleAction(actionEvent);
    }
}
