package interfaces;

/**
 * Created by SF on 2016/4/27.
 */
public class Percussion extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Percussion.play:" + note);
    }

    @Override
    public void adjust() {

    }

    @Override
    public String what() {
        return "Percussion;\t";
    }
}
