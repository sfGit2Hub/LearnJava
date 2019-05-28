package design.pattern.observe;

/**
 * Created by Administrator on 2019/5/28.
 */
public class CurrentConditionsDisplay implements Observe, Display {
    private String value;
    private Subject<Observe> weatherData;

    public CurrentConditionsDisplay(Subject<Observe> weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(String value) {
        this.value = value;
        display();
    }

    @Override
    public void display() {
        System.out.println(this.getClass().getName() + "-Value-" + value);
    }
}
