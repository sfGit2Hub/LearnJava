package design.pattern.factory;

/**
 * Created by Administrator on 2019/3/13.
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "芝加哥厚饼风味披萨";
        dough = "加厚厚皮面团";
        sauce = "梨形番茄酱";

        toppings.add("意大利干白奶酪");
    }

    @Override
    void cut() {
        System.out.println("讲披萨切成正方形");
    }
}
