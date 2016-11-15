package type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SF on 2016/10/17.
 */
public class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type) {
        this.type = type;
    }
    public List create(int elementNum) {
        List<T> filledList = new ArrayList<>();
        try {
            for (int i = 0; i < elementNum; i++) {
                filledList.add(type.newInstance());
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return filledList;
    }

    public static void main(String []args) {
        FilledList<CounterInteger> filledList = new FilledList<>(CounterInteger.class);
        System.out.println(filledList.create(10));
    }
}
