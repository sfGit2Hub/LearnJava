package lintcode;

public class 单词广场 {
    /**
     * 给定
     * [
     *   "abcd",
     *   "bnrt",
     *   "crmy",
     *   "dtye"
     * ]
     * 返回 true
     *
     * 解释:
     * 第一行和第一列都是“abcd”。
     * 第二行和第二列都是“bnrt”。
     * 第三行和第三列都是“crmy”。
     * 第四行和第四列都是“dtye”。
     * 因此，这是一个有效的单词广场.
     *
     * @param words: a list of string
     * @return: a boolean
     */
    public static boolean validWordSquare(String[] words) {
        // Write your code here
        if (words == null) return false;
        if (words.length == 1) {
            return words[0].length() == 0;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].length() != words[i+1].length())
                return false;
        }
        char[][] matrix = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            matrix[i] = words[i].toCharArray();
        }
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] input = new String[]{
                "abcd",
                "bnrt",
                "crmy",
                "dtye"
        };
        boolean result = validWordSquare(input);
        System.out.println(result);
    }
}
