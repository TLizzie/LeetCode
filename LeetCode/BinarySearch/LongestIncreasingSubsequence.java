package LeetCode.BinarySearch;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * 7/8/2019
 * Binary Search
 * i, j 相当于 tails 的起点 终点
 * res相当于 tail的实际长度
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] tails = new int[nums.length];

        for (int num : nums) {
            int i = 0, j = res;
            while (i != j) {
                int mid = i + (j - i) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (i == res) res++;
        }
        return res;
    }


    //dp
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
