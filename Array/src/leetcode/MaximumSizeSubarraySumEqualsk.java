package Array.src.leetcode;

import java.util.HashMap;

/**
 * 325.Maximum Size Subarray Sum Equals k
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 *
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 *
 * Example 1:
 *
 * Input: nums = [1, -1, 5, -2, 3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * Example 2:
 *
 * Input: nums = [-2, -1, 2, 1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 * Follow Up:
 * Can you do it in O(n) time?
 */
public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);         //放置第一个元素 可以将第一个元素纳入并且计算长度

        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                res = Math.max(res, i - map.get((nums[i] - k)));
            }
            // 不更新原有tuple 因为是求max距离 如果是min则更新
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
