package LeetCode.String;

import java.util.HashMap;

/**
 * 159.Longest Substring with At Most Two Distinct Characters
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 *
 * Example 1:
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 *
 * Example 2:
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public int longestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int res = 0;
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(end), end);
                end++;
            }
            if (map.size() > 2) {
                int leftMost = s.length();
                for (int num : map.values()) {
                    leftMost = Math.min(leftMost, num);
                }
                map.remove(s.charAt(leftMost));
                start = leftMost + 1;
            }
            // since end++
            res = Math.max(res, end - start);
        }
        return res;
    }
}

