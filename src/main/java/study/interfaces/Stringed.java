package study.interfaces;

/**
 * Created by SF on 2016/4/27.
 */
public class Stringed extends Instrument {

    @Override
    public void play(Note note) {
        System.out.println("Stringed.play:" + note);
    }

    @Override
    public void adjust() {

    }

    @Override
    public String what() {
        return "Stringed;\t";
    }
}
