package study.operator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SF on 2016/3/25.
 */
public class DevilNum {
    public static boolean isDevilNum(int num) {
        int a, b, c, d;
        a = num/1000;
        b = (num - a*1000)/100;
        c = (num - a*1000 - b*100)/10;
        d = num - a*1000 - b*100 - c*10;
        int[] nums = new int[4];
        nums[0] = a;
        nums[1] = b;
        nums[2] = c;
        nums[3] = d;
        return true;
    }

    private static List group(int[] nums) {
        List numList = Arrays.asList(nums);
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++) {
                if (i==j) continue;
                int numOne = nums[i]*10 + nums[j];
                int numTwo = nums[i];
            }
        }
        return numList;
    }
}
