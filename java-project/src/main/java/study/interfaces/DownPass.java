package study.interfaces;

/**
 * Created by SF on 2016/4/28.
 */
public class DownPass extends Filter {
    private double cutoff;
    public DownPass(double cutoff){
        this.cutoff = cutoff;
    }

    @Override
    public WaveForm process(WaveForm input) {
        return super.process(input);
    }

    public double getCutoff() {
        return cutoff;
    }

    public void setCutoff(double cutoff) {
        this.cutoff = cutoff;
    }
}
