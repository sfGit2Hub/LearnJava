package design.pattern.factory;

/**
 * Created by Administrator on 2019/3/13.
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(PizzaType pizzaType) {
        if (pizzaType == PizzaType.CheesePizza)
            return new NYStyleCheesePizza();
        else if (pizzaType == PizzaType.Pepperoni)
            return new NYStylePepperoniPizza();
        return null;
    }
}
