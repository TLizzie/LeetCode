package LeetCode.String;

/**
 * 5. Longest Palindromic Substring
 * 6/27/2019
 * 回文的两种形式： 奇数， 偶数
 * 动态规划
 * 函数 ： 中心扩散
 * time : O(n^2)
 * space: O(1)
 */
public class LongestPalindromicSubstring {
    String res = "";
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return res;
    }
    public void extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length())
            res = cur;
    }

//dp
    public String longestPalindrom2(String s) {
        if (s == null || s.length() == 0)
            return "";
        int max = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
