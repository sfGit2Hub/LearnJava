package design.pattern.decorator;

/**
 * Created by Administrator on 2019/6/24.
 *
 */
public class HouseBlend extends Beverage {
    public HouseBlend(){
        this.description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 2.5;
    }
}
