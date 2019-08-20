package LeetCode.Array;

/**
 * Leetcode 136 Single Number
 * 5/29
 * bitwise manipulation
 *
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
