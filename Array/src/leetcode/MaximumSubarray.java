package Array.src.leetcode;

/**
 * Leetcode 53 Maximum Subarray
 * 6/5/2019
 * DP programming
 *
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(max + nums[i], res);
            max = Math.max(max, res);
        }
        return max;

    }
}
