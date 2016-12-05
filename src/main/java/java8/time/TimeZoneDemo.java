package java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by SF on 2016/12/5.
 */
public class TimeZoneDemo {
    public static void main(String[] args) {
        ZoneId america = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
        String local = "UTC-3:00";
        ZonedDateTime zonedDateTimeLocale = ZonedDateTime.of(LocalDateTime.now(), america);
        System.out.println(zonedDateTimeLocale);
    }
}
