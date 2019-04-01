package design.pattern.factory;

/**
 * Created by Administrator on 2019/3/13.
 */
public class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        name = "芝加哥风味腊香肠披萨";
        dough = "小麦纯面团";
        sauce = "辣酱加少番茄酱";

        toppings.add("覆盖进口烟熏腊香肠");
    }
}
