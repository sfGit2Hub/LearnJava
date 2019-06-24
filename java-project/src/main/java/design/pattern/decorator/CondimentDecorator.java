package design.pattern.decorator;

/**
 * Created by Administrator on 2019/6/24.
 * 调料类将继承此装饰器
 */
public abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();
}
