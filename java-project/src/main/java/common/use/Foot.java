package common.use;

import com.google.common.base.MoreObjects;
import persistent.DynamicArrayList;

import java.util.List;

/**
 * Created by SF on 2018/3/2.
 */
public class Foot {
    private double length;
    private double weight;
    private double thick;
    private List<Toe> toes = new DynamicArrayList<>(Toe.class);

    public Foot(){}

    public Foot(double length, double weight, double thick) {
        this.length = length;
        this.weight = weight;
        this.thick = thick;
    }

    public Foot(String param, String param1, String param2) {
        this.length = Double.valueOf(param);
        this.weight = Double.valueOf(param1);
        this.thick = Double.valueOf(param2);
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

    public List<Toe> getToes() {
        return toes;
    }

    public Foot setToes(List<Toe> toes) {
        this.toes = toes;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("length", length)
                .add("weight", weight)
                .add("thick", thick)
                .add("toes", toes)
                .toString();
    }
}
