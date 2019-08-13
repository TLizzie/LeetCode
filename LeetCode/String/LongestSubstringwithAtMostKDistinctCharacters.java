package LeetCode.String;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 *
 * Example 1:
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 *
 * Example 2:
 *
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 *
 * sliding window
 * 首先有数组来记录每一个字母
 *
 * "eceba", k = 2
 *      i
 * num = 3
 * j = 2
 *
 * count[e] = 1
 * count[c] = 0
 *
 * time: O(n)
 * space: O(1)
 *
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    public int longestSubstring(String s, int k) {
        int[] count = new int[256];
        int res = 0, num = 0, j = 0;    //num 记录出现的不同字母数
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) {
                num++;
            }
            if (num > k) {
                while (--count[s.charAt(j++)] > 0);
                num--;
            }
            res = Math.max(res, i - j + 1);
        }

        return res;

    }
}
