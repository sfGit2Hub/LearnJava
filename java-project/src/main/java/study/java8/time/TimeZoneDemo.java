package study.java8.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

        LocalDateTime localDateTime1 = LocalDateTime.parse("2017-03-21" + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String startDate = ZonedDateTime.of(localDateTime1, ZoneId.of("GMT+08:00"))
                .withZoneSameInstant(ZoneId.of("UTC+00:00"))
                .toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.forLanguageTag("zh_CN")));
        System.out.println(startDate);
    }
}
