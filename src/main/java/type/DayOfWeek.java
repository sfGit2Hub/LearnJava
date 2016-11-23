package type;

/**
 * Created by SF on 2016/11/23.
 */
public enum  DayOfWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int num;

    DayOfWeek(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public static void main(String[] args) {
        DayOfWeek Monday = DayOfWeek.MONDAY;
        DayOfWeek Tuesday = DayOfWeek.TUESDAY;
        System.out.println(Monday.compareTo(Tuesday));
    }
}
