package persistent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by SF on 2016/5/18.
 * 创建一个迭代器，从数组最后一个元素向前迭代
 */
public class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> collection) {
        super(collection);
    }

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }

                    public void remove(){
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
