package lintcode;

public class BinarySearch {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public static int binarySearch(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        if ((end - start) == 1) {
            if (nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;
            } else {
                return -1;
            }
        }
        if (start == end && nums[start] != target) {
            return -1;
        }

        int midIndex = start + (end - start) / 2;
        if (nums[midIndex] >= target) {
            return binarySearch(nums, start, midIndex, target);
        } else if (nums[midIndex] < target) {
            return binarySearch(nums, midIndex, end, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,4,4,5,7,7,8,9,9,10};
        System.out.println(binarySearch(arrays, 11));
    }

}
