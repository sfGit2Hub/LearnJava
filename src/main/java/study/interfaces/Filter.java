package study.interfaces;

/**
 * Created by SF on 2016/4/28.
 */
public class Filter {
    public String name(){
        return this.getClass().getSimpleName();
    }

    public WaveForm process(WaveForm input){
        return input;
    }
}
