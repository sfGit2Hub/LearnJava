package RTTI;

/**
 * Created by SF on 2016/7/4.
 */
interface HasBatteries {
}

interface Waterproof{

}

interface Shoots{

}

class Toy{
    public Toy(){}
    public Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    public FancyToy(int i) {
        super(i);
    }
}
