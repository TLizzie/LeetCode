package LeetCode.Array;
/**
 * Leetcode 238 Product of Array Except Self
 * 6/9/2019
 * ??不知道是啥玩意
 * 没太懂
 * 双向扫描
 * 第一次扫 是 当前元素左边的乘积
 * 二次扫描是右边元素的乘积
 *
 *
 * [1, 2, 3, 4]
 * [1, 1, 2, 6]
 * [24, 12, 8, 6]
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i++) {
            res[i] = res[i] * right;
            right *= nums[i];
        }
        return res;
    }
}