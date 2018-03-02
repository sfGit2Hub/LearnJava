package persistent;

import java.util.ArrayList;

/**
 * Created by SF on 2018/3/2.
 */
public class DynamicArrayList<E> extends ArrayList<E> {
    private static final long serialVersionUID = 3627872742516284547L;
    private Class<E> eClass;

    public DynamicArrayList(Class<E> eClass) {
        this.eClass = eClass;
    }

    /**
     * adds element at specific index. if element is above list size, fills nulls in between
     *
     * @param index - index
     * @param element - element to add
     */
    @Override
    public void add(int index, E element) {
        //normal arraylist set(index, element) behavior
        if (index >= 0 && index < size()) {
            super.set(index, element);
            return;
        }

        //if adding element at position outside of size, fill with nulls
        int insertNulls = index - size();
        for (int i = 0; i < insertNulls; i++) {
            super.add(null);
        }

        //finally add element position
        super.add(element);
    }

    /**
     * gets element at index. if value does not exist, creates new instance of element at location
     *
     * @param index - index
     * @return element, or new element depending on pre-existence
     */
    @Override
    public E get(int index) {
        try {
            if (index >= size()) {
                add(index, eClass.newInstance());
            } else if (super.get(index) == null) {
                set(index, eClass.newInstance());
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return super.get(index);
    }
}
