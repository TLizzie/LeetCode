package LeetCode.Array;

/**
 * Leetcode  245 Shortest Word Distance III
 * 2019/5/23
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 * time : O(n)
 * space : O(1)
 */
public class ShortestWordDistanceIII {
    public int shortesetWordDistance(String[] words, String word1, String word2) {
        int res = words.length;
        int a = -1;
        int b = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            }

            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    a = b;
                }
                b = i;
            }

            if (a != -1 && b != -1) {
                res = Math.min(res, Math.abs(a - b));
            }
        }
        return res;
    }

}
