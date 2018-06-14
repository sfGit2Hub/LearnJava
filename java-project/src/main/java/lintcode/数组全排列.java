package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 数组全排列 {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList();
        permute(nums, 0, result);
        return result;
    }

    private static void permute(int[] nums, int m, List<List<Integer>> result) {
        int current;
        if(m == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i = m; i < nums.length; i++) {
                current = nums[m];
                nums[m] = nums[i];
                nums[i] = current;
                permute(nums, m + 1, result);
                current = nums[m];
                nums[m] = nums[i];
                nums[i] = current;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        List<List<Integer>> result = permute(array);
        System.out.println(result);
    }
}
