package initial;

/**
 * Created by SF on 2016/4/6.
 */
public interface EnumInterface {
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO;
    }
    enum Fruit implements Food{
        APPLE, BALANA
    }
}
