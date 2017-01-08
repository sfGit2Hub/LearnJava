package study.initial;

/**
 * Created by SF on 2016/4/6.
 */
enum Color implements Food{
    RED("红色", 1), BLUE("蓝色", 2), BLACK("黑色", 3), YELLOW("黄色", 4);
    private String name;
    private int index;

    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) return c.getName();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

public class EnumInitial {
    public static String showValue(Color color) {
        switch (color) {
            case RED:
                return Color.getName(color.getIndex());
            case BLUE:
                return Color.getName(color.getIndex());
            case BLACK:
                return Color.getName(color.getIndex());
            case YELLOW:
                return Color.getName(color.getIndex());
            default: return null;
        }
    }

    public static void main(String[] args) {
        Color red = Color.RED;
        System.out.println(showValue(red));
    }
}
