package string;

import java.util.Random;

/**
 * Created by SF on 2016/5/19.
 */
public class UsingStringBuilder {
    public static Random random = new Random(47);

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i=0; i<20; i++) {
            sb.append(random.nextInt(100));
            sb.append(",");
        }
        sb.delete(sb.length()-1, sb.length());
        sb.append("]");
        return sb.toString();
//        StringBuilder result = new StringBuilder("[");
//        for (int i=0; i<20; i++) {
//            result.append(random.nextInt(100));
//            result.append(",");
//        }
//        result.delete(result.length()-1, result.length());
//        result.append("]");
//        return result.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder builder = new UsingStringBuilder();
        System.out.println(builder);
    }
}
