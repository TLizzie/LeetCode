package LeetCode.String;

import java.util.HashSet;

/**
 * 3. Longest Substring Without Repeating Characters
 * time: O(n)
 * space: O(n)
 * j 代表不重复字母的起点
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int i = 0, j = 0, max = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j++))) {
                set.add(s.charAt(j));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
