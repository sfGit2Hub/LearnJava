package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlipGame {
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public static List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> results = new LinkedList<>();
        if (s == null || s.length() < 2) {
            return results;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            char[] arrays = s.toCharArray();
            if (arrays[i] == '-' || arrays[i+1] == '-'){
                continue;
            }
            arrays[i] = '-';
            arrays[i+1] = '-';
            ((LinkedList<String>) results).addFirst(new String(arrays));
        }
        return results;
    }
//input: +----+-++-++--+++-+--+----+-+-+-+++--+++
//output: ["+----+-++-++--+++-+--+----+-+-+-+++--+--",
// "+----+-++-++--+++-+--+----+-+-+-+++----+",
// "+----+-++-++--+++-+--+----+-+-+-+----+++",
// "+----+-++-++--+++-+--+----+-+-+---+--+++",
// "+----+-++-++--+---+--+----+-+-+-+++--+++",
// "+----+-++-++----+-+--+----+-+-+-+++--+++",
// "+----+-++-----+++-+--+----+-+-+-+++--+++",
// "+----+----++--+++-+--+----+-+-+-+++--+++"]
    public static void main(String[] args) {
        List<String> result = generatePossibleNextMoves("+----+-++-++--+++-+--+----+-+-+-+++--+++");
        System.out.println(result);

    }
}
