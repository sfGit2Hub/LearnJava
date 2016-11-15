package java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by SF on 2016/7/21.
 */
public class LocalDateTimeDemo {
    public static void main(String[] agrs){
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime newDateTime = LocalDateTime.of(date, time);
    }
}
