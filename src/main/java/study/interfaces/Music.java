package study.interfaces;

/**
 * Created by SF on 2016/4/27.
 */
public class Music {
    static void tune(Instrument instrument){
        instrument.play(Note.Mi);
    }

    static void tune(Instrument[] instruments){
        for (Instrument i : instruments){
            tune(i);
        }
    }

    public static void main(String[] args){
        Instrument instrument = new Instrument() {
            @Override
            public void play(Note note) {
                System.out.println("内部类方法Instrument.paly:" + note);
            }

            @Override
            public void adjust() {

            }
        };
        Instrument[] instruments = {
                new Wind(),
                new Woodwind(),
                new Brass(),
                new Stringed(),
                new Percussion()
        };
        tune(instrument);
        tune(instruments);
    }
}
