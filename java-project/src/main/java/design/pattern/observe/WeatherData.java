package design.pattern.observe;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/28.
 */
public class WeatherData implements Subject<Observe> {
    private List<Observe> observes;
    private String value;

    @Override
    public void registerObserver(Observe observe) {
        if (observes == null) observes = new LinkedList<>();
        observes.add(observe);
    }

    @Override
    public void removeObserver(Observe observe) {
        if (observes == null) return;
        observes.remove(observe);
    }

    @Override
    public void notifyObservers() {
        if (observes == null) return;
        for (Observe o : observes) {
            o.update(value);
        }
    }

    public void changeValue(String value){
        this.value = value;
        notifyObservers();
    }
}
