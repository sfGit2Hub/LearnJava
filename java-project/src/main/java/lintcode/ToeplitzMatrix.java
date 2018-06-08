package lintcode;

public class ToeplitzMatrix {
    /**
     * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
     *
     * @param matrix: the given matrix
     * @return: True if and only if the matrix is Toeplitz
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            int temp = matrix[0][j];
            int col = j + 1;
            for (int i = 1; i < matrix.length && col < matrix[0].length; i++, col++) {
                if (temp != matrix[i][col])
                    return false;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            int temp = matrix[i][0];
            int row = i + 1;
            for (int j = 1; j < matrix[0].length && row < matrix.length; j++) {
                if (temp != matrix[row++][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 1, 2, 3};
        matrix[2] = new int[]{9, 5, 1, 2};
        matrix[3] = new int[]{9, 9, 5, 1};
        boolean result = isToeplitzMatrix(matrix);
        System.out.println(result);
    }
}
