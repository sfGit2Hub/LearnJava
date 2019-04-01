package design.pattern.factory;

/**
 * Created by Administrator on 2019/3/13.
 */
public class FactoryMainTest {
    public static void main(String[] args) {
        PizzaStore NYstore = new NYPizzaStore();
        PizzaStore ChicagoStore = new ChicagoPizzaStore();

        Pizza pizzaA = NYstore.orderPizza(PizzaType.CheesePizza);
        System.out.println("我在纽约披萨店订了一个 " + pizzaA.getName());
    }
}
