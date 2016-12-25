package study.interfaces;

/**
 * Created by SF on 2016/4/27.
 */
public class Brass extends Wind {
    @Override
    public void play(Note note) {
        System.out.println("Brass.play:" + note);
    }

    @Override
    public void adjust() {
    }

    @Override
    public String what() {
        return "Brass;\t";
    }
}
