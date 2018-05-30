package lintcode;

public class 旋转字符串 {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public static void rotateString(char[] str, int offset) {
        // write your code here
        if (str.length < 1 || offset < 1) {
            return;
        }
        offset = offset % str.length;
        while (offset > 0) {
            char temp = str[str.length - 1];
            for (int i = str.length - 1; i > 0; i--) {
                str[i] = str[i-1];
            }
            str[0] = temp;
            offset--;
        }
        System.out.println(new String(str));
    }

    public static void main(String[] args) {
//        new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        rotateString("timelimiterror".toCharArray(), 1000000000);
    }
}
