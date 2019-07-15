package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 244.Shortest Word DistanceII
 * 2019/5/23
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * Your method will be called repeatedly many times with different parameters.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 *
 * Using HashMap
 */
class ShortestWordDistanceII {
        // word  index list
    private HashMap<String, List<Integer>> map;
    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i],list);
            }

        }
    }

    // time : O(m * n)
    public int Shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for (Integer i : l1) {
            for (Integer j : l2) {
                res = Math.min(res, Math.abs(j - i));
            }
        }
        return res;
    }

    // time : O(m + n)
    public int ShortestI(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) < l2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }


}
