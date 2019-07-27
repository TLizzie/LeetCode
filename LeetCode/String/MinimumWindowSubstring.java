package LeetCode.String;

/**
 * 76. Minimum Window Substring
 * len 判断substring中是否包含t的字符
 * sliding window典型题
 * 7/27/2019
 * 背下来
 * 时间复杂度： O(2n) i走一遍 j走一遍
 *
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] count = new int[256];
        for (char ch : t.toCharArray()) {
            count[ch]++;
        }

        int len = t.length();
        int from = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]-- > 0) {
                len--;
            }
            while (len == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++count[s.charAt(j++)] > 0) {
                    len++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(from, min + from);
    }
}
