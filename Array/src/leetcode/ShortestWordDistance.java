package leetcode;

import java.util.HashMap;

/**
 * 243.Shortest Word Distance
 * 2019/5/23
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * 非常基础了
 */
public class ShortestWordDistance {

    //time : O(n2)
    public static int ShortedDistance(String[] words, String word1, String word2) {
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        res = Math.min(res, Math.abs(j - i));
                    }
                }
            }
        }
        return res;
    }


    // time : O(n)
    public static int ShortedDistanceI(String[] words, String word1, String word2) {
        int res = words.length;
        int a = -1;
        int b = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            } else if (words[i].equals(word2)) {
                b = i;
            }

            if (a != -1 && b != -1) {
                res = Math.min(res, Math.abs(a - b));
            }
        }
        return res;
    }

}
