package interfaces;

/**
 * Created by SF on 2016/4/27.
 */
public class Woodwind extends Wind {
    @Override
    public void play(Note note) {
        System.out.println("Woodwind.play:" + note);
    }

    @Override
    public void adjust() {
    }

    @Override
    public String what() {
        return "Woodwind;\t";
    }
}
