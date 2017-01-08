package study.java8.time;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by SF on 2016/4/29.
 */
public class LocaleTimeCase {
    public static void main(String[] args){
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println("The hour of the day:" + localTime.getHour());
        // add 2 hours to the time
        System.out.println(localTime.plus(2, ChronoUnit.HOURS));
        // add 6 minutes to the time
        System.out.println(localTime.plus(6, ChronoUnit.MINUTES));
        // substract 2 hours from current time
        System.out.println(localTime.minus(2, ChronoUnit.HOURS));
    }
}
