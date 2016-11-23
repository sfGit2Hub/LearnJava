package interfaces;

/**
 * Created by SF on 2016/4/27.
 */
public abstract class Instrument {
    public abstract void play(Note note);

    public String what() {
        return "";
    }

    public abstract void adjust();
}
