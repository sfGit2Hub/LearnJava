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

        Mouse mouse = new Mouse();
        Button button = new Button();
        //加监听器
        button.addListener(new EventListener());
        button.addListener(new ClickEventListener());
        //触发点击事件
        mouse.ClickButton(button);

    }
}
