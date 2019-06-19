package Array.src.leetcode;

/**
 * Leetcode 152. Maximum Product Subarray
 * 6/19/2018
 * time : O(n)
 * space : O(1)
 * max, min语句的原因：
 * 同nums[i]比较，可能是负数， 也可能是正数 乘积过后
 *
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;                                         //remember to store the value of max since it will change later
            max = Math.max(Math.max(nums[i] * max, min * nums[i]), nums[i]);
            min = Math.min(Math.min(nums[i] * min, temp * nums[i]), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
