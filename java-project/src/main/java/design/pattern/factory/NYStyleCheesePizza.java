package design.pattern.factory;

/**
 * Created by Administrator on 2019/3/13.
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "纽约大蒜披萨";
        dough = "薄皮生面团";
        sauce = "番茄酱";

        toppings.add("覆盖Reggiano干酪"); //意大利reggiano高级芝士
    }
}
