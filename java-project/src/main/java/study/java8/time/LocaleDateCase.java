package study.java8.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by SF on 2016/4/29.
 */
public class LocaleDateCase {
    public static void main(String[] args){
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.parse("2017-08-23");
        System.out.println("Period day:" + localDate.until(localDate2).getDays());
        System.out.println(localDate);
        System.out.println("The number of days available for this month:" + localDate.lengthOfMonth());
        System.out.println("The month name is :" + localDate.getMonth().name());
        System.out.println("Add two days of today:" + localDate.plus(2, ChronoUnit.DAYS));
        System.out.println("Convert the study.string to date:" + LocalDate.parse("2016-03-09"));
        System.out.println(localDate.atStartOfDay());
        System.out.println(localDate.minusDays(5));
        System.out.println(localDate.minusDays( localDate.toEpochDay() ) );
        System.out.println(LocalDate.MAX);
    }
}
