package lintcode;

/**
 * Created by SF on 2018/5/23.
 */
public class 第k大元素 {
    /**
     * 要求时间复杂度为O(n)，空间复杂度为O(1)
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums.length < 1 || k < 1)
            return 0;
        if (nums.length == 1) {
            return nums[0];
        }
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length - k];
    }

    public void quickSort(int[] array, int low, int high) {
        if (low >= high || array.length <= 1) {
            return;
        }
        int left = low;
        int right = high;
        int provi = array[left];
        while (left < right) {
            while (left < right && array[right] >= provi) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= provi) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = provi;

        quickSort(array, low, left-1);
        quickSort(array, left + 1, high);
    }


}
