package design.pattern.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2019/5/29.
 */
public class CurrentConditionsDisplayV2 implements Observer {
    private WeatherDataV2 weatherData;

    public CurrentConditionsDisplayV2(WeatherDataV2 weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
