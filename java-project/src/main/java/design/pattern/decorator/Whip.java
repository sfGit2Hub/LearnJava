package design.pattern.decorator;

/**
 * Created by Administrator on 2019/6/24.
 */
public class Whip extends CondimentDecorator {
    private Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip ";
    }

    @Override
    public double cost() {
        return .3 + beverage.cost();
    }
}
