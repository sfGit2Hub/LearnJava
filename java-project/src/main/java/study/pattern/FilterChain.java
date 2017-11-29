package study.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SF on 2017/11/29.
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<>();
//    调用链上的过滤器时，记录过滤器的位置用
    private int index = 0;

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index == filters.size())
            return;
        Filter filter = filters.get(index);
        index++;
//        双向过滤器
        filter.doFilter(request, response, this);
    }
}
