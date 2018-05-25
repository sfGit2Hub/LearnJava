package lintcode;

public class 合并两个排序数组 {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public static int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int[] megerArray = new int[A.length + B.length];
        int a = 0, b = 0, index = 0;
        while (a < A.length || b < B.length) {
            if (a == A.length) {
                megerArray[index++] = B[b];
                b++;
            } else if (b == B.length) {
                megerArray[index++] = A[a];
                a++;
            } else if (A[a] < B[b]) {
                megerArray[index++] = A[a];
                a++;
            } else {
                megerArray[index++] = B[b];
                b++;
            }
        }
        return megerArray;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4};
        int[] B = new int[]{2,4,5,6};
        for (int temp : mergeSortedArray(A, B)) {
            System.out.print(temp + "\t");
        }
    }
}
