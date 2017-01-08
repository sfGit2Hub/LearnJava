package study.interfaces;

/**
 * Created by SF on 2016/4/28.
 */
public class FilterAdapter implements Processor {
    private Filter filter;
    public FilterAdapter(Filter filter){
        this.filter = filter;
    }
    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        if (input instanceof WaveForm)
            return filter.process((WaveForm)input);
        return input;
    }
}
