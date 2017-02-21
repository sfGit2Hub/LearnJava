package common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

public class DateConvert {
    public static LocalDate dateToLocalDate(Date date, ZoneId zoneId) {
        return date.toInstant().atZone(zoneId).toLocalDate();
    }

    public static String formatDateAndLocale(Date date, Locale locale) {
        if (Objects.isNull(date)) {
            return null;
        }
        if (Objects.isNull(locale)) {
            locale = Locale.ENGLISH;
        }
        //多语言情况下格式化
        return new SimpleDateFormat("dd MMM yyyy", locale).format(date);
    }

    public static String formatDate(Date date, String pattern) {
        if (Objects.isNull(date)) {
            return null;
        }
        if (Objects.isNull(pattern)) {
            pattern = "dd MMM yyyy";
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String formatDate(Date date) {
        return formatDate(date, null);
    }

    public static void main(String []args) {
        String dateStr = formatDateAndLocale(new Date(), Locale.ENGLISH);
        System.out.println(dateStr);
        SimpleDateFormat parser = new SimpleDateFormat("dd MMM yyyy");
        try {
            Date date = parser.parse("12 十一月 2016");    //区域语言不同不能解析，Locale.CHINA才可以
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
