package interfaces;

/**
 * Created by SF on 2016/4/28.
 */
public class FilterProcess {
    public static void main(String[] arga){
        WaveForm w = new WaveForm();
        WaveForm w2 = new WaveForm();
        Apply.process(new FilterAdapter(new DownPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(new FilterAdapter(new DownPass(1.0)), w2);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w2);
    }
}
