package persistent;

import java.util.Arrays;

/**
 * Created by SF on 2016/5/18.
 */
public class AdapterMethodIdiom {
    public static void main(String[] args){
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(
                Arrays.asList("The string is split !".split(" "))
        );

        for (String s : ral) {
            System.out.print(s + " + ");
        }
        System.out.println();

        for (String s : ral.reversed()) {
            System.out.printf(s + " + ");
        }
    }
}
