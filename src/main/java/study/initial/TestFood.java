package study.initial;

/**
 * Created by SF on 2016/4/26.
 */
public class TestFood {
    public static void showClassName(Food food){
        //向上转型，实际类只需要实现Food接口即可
        System.out.println(food.getClass().getName());
    }

    public static void main(String[] args){
        Apple apple = new Apple();
        Meat meat = new Meat();
        showClassName(apple);
        showClassName(meat);
    }
}
