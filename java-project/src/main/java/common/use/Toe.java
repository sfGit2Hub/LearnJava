package common.use;

import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * Created by SF on 2018/3/2.
 */
public class Toe {
    private String name;
    private List<Fur> furs;

    public Toe() {
    }

    public Toe(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public Toe setName(String name) {
        this.name = name;
        return this;
    }

    public List<Fur> getFurs() {
        return furs;
    }

    public Toe setFurs(List<Fur> furs) {
        this.furs = furs;
        return this;
    }
}
