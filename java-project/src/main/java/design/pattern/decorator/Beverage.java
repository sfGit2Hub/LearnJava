package design.pattern.decorator;

/**
 * Created by Administrator on 2019/6/24.
 */
public abstract class Beverage {
    String description = "未知饮料";

    public  String getDescription(){
        return this.description;
    }

    public abstract double cost();
}
