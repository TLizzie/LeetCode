package LeetCode.DynamicProgramming;

import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), 0);
    }
    public boolean helper(String s, HashSet<String> set, int index) {
        if (index == s.length())
            return true;
        for (int i = index + 1; i <= s.length() + 1; i++) {
            if (set.contains(s.substring(index, i))) {
                if (helper(s, set, i)) {
                    return true;
                }
            }
        }
        return false;
    }


    //backtracking
    public boolean wordBreak2(String s, List<String> wordDict) {
        return helper2(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean helper2(String s, HashSet<String> set, int index, Boolean[] memo) {
        if (index == s.length()){
            return true;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (set.contains(s.substring(index, i)) && helper2(s, set, i, memo)) {
                memo[index] = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }


    //dp
    public boolean wordBreak3(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
