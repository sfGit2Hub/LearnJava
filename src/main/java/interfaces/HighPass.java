package interfaces;

/**
 * Created by SF on 2016/4/28.
 */
public class HighPass extends Filter {
    private double cutoff;
    public HighPass(double cutoff){
        this.cutoff = cutoff;
    }
    @Override
    public WaveForm process(WaveForm input) {
        return input;
    }

    public double getCutoff() {
        return cutoff;
    }

    public void setCutoff(double cutoff) {
        this.cutoff = cutoff;
    }
}
