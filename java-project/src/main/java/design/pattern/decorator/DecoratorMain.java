package design.pattern.decorator;

/**
 * Created by Administrator on 2019/6/24.
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + "; cost:" + beverage.cost());

        Beverage beverage1 = new Espresso();
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription() + "; cost:" + beverage1.cost());
    }
}
