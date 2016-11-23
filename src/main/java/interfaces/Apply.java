package interfaces;

/**
 * Created by SF on 2016/4/28.
 */
public class Apply {
    private static String s = "I'm a good man!";

    public static void process(Processor processor, Object input){
        System.out.println(processor.name());
        System.out.println(processor.process(input));
    }

    public static void main(String[] args){
        process(new UpCase(), s);
        process(new LowerCase(), s);
        process(new SplitCase(), s);
    }
}
