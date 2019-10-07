package LeetCode.DynamicProgramming;

/**
 * 647. Palindromic Substrings
 * almost the same as 5
 *
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (j - i <= 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }


}
