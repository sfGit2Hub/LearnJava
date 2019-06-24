package design.pattern.decorator;

/**
 * Created by Administrator on 2019/6/24.
 * 浓缩咖啡
 */
public class Espresso extends Beverage {
    public Espresso(){
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
