package design.pattern.factory;

/**
 * Created by Administrator on 2019/3/13.
 */
public abstract class PizzaStore {
    abstract Pizza createPizza(PizzaType pizzaType);

    Pizza orderPizza(PizzaType pizzaType) {
        Pizza pizza = createPizza(pizzaType);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
