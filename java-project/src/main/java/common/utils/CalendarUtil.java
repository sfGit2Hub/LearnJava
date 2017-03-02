package common.utils;

import java.util.Calendar;

/**
 * Created by SF on 2017/2/24.
 */
public class CalendarUtil {
    private static Calendar[] getTimeLine(long currentWed) {
        Calendar[] calendars = new Calendar[8];
        for (int i = 0; i < 8; i++) {
            Calendar tempTime = Calendar.getInstance();
            tempTime.setTimeInMillis(currentWed);
            tempTime.add(Calendar.DAY_OF_YEAR, (-7) * i);
            calendars[i] = tempTime;
        }
        return calendars;
    }

    public static void main(String[] args) {
        Calendar[] calendars = getTimeLine(System.currentTimeMillis());
        System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_YEAR));
        for (Calendar calendar : calendars) {
            System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        }
    }
}
