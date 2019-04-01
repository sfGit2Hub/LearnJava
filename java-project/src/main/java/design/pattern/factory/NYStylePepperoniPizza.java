package design.pattern.factory;

/**
 * Created by Administrator on 2019/3/13.
 */
public class NYStylePepperoniPizza extends Pizza {
    public NYStylePepperoniPizza() {
        name = "纽约风味腊香肠披萨";
        dough = "腊香肠面团";
        sauce = "辣酱加芝士酱";

        toppings.add("覆盖腊香肠片");
    }
}
