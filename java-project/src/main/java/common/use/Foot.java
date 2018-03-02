package common.use;

import com.google.common.base.MoreObjects;

/**
 * Created by SF on 2018/3/2.
 */
public class Foot {
    private double length;
    private double weight;
    private double thick;

    public Foot(double lenght, double weight, double thick) {
        this.length = lenght;
        this.weight = weight;
        this.thick = thick;
    }

    public double getLength() {
        return length;
    }

    public Foot setLength(double length) {
        this.length = length;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public Foot setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public double getThick() {
        return thick;
    }

    public Foot setThick(double thick) {
        this.thick = thick;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("length", length)
                .add("weight", weight)
                .add("thick", thick)
                .toString();
    }
}
