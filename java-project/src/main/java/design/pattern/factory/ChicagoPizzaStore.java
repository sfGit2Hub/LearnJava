package design.pattern.factory;

/**
 * Created by Administrator on 2019/3/13.
 */
public class ChicagoPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(PizzaType pizzaType) {
        if (pizzaType == PizzaType.CheesePizza)
            return new ChicagoStyleCheesePizza();
        else if (pizzaType == PizzaType.Pepperoni)
            return new ChicagoStylePepperoniPizza();
        return null;
    }
}
