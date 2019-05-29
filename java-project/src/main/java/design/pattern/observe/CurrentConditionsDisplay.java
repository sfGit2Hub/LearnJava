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
    public void display() {
        if (weatherData instanceof WeatherData){
            WeatherData weatherData1 = (WeatherData)weatherData;
            if (value == null) {
                System.out.println(this.getClass().getName() + "-Value-" + weatherData1.getValue());
            }else {
                System.out.println(this.getClass().getName() + "-Value-" + value);
            }

        }
    }

    @Override
    public void update(Subject subject) {
        this.weatherData = subject;
        display();
    }

    @Override
    public void update(Subject subject, Object arg) {
        this.weatherData = subject;
        this.value = (String) arg;
        display();
    }
}
