package study.reusable;

/**
 * Created by SF on 2016/4/15.
 */
public class FinalData {
    private String id;

    public final int int_1 = 1;
    public static final int INT_1 = 11;

    private final int int_2 = 2;
    private static final int INT_2 = 12;

    public final Value v1 = new Value(3);
    public final static Value v2 = new Value(13);

    private final Value v4 = new Value(4);
    private final static Value v5 = new Value(14);

    public FinalData(String id) {
        this.id = id;
    }

    public void finalMethod(final int i){
//        ++i;
    }

    public void finalMethod(final Value value) {
//        value = new Value(3);
    }
    
    public static void main(String[] args){
        FinalData finalData = new FinalData("final");
        System.out.println(++finalData.v4.i);
//        finalData.v4 = new Value(5);
//        INT_1 = 2;
    }
}
