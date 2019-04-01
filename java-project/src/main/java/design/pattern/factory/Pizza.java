package design.pattern.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/13.
 */
public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<>();

    void prepare() {
        System.out.println("准备 " + name);
        System.out.println("揉面...");
        System.out.println("加佐料...");
        System.out.println("加覆盖料...");
        for (String topping : toppings) {
            System.out.println("    " + topping);
        }
    }

    void bake(){
        System.out.println("350℃ 烘烤 25分钟");
    }

    void cut(){
        System.out.println("将披萨切成斜分块");
    }

    void box(){
        System.out.println("将披萨装入官方提供的盒子里");
    }

    public String getName(){
        return name;
    }
}
