package study.interfaces;

/**
 * Created by SF on 2016/4/28.
 */
public abstract class StringProcess implements Processor{
    @Override
    public String name() {
        return getClass().getSimpleName();
    }


}
