package design.pattern.observe;

/**
 * Created by Administrator on 2019/5/28.
 */
public class ObserveMainTest {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
//        Observe currentDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.registerObserver(new CurrentConditionsDisplay(weatherData));

        weatherData.changeValue("aaa");
    }
}
