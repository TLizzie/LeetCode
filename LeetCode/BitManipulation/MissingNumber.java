package LeetCode.BitManipulation;

import java.util.Arrays;

/**
 * Leetcode  268 Missing Number
 * 6/1
 * bit manipulation 很重要 但是难想
 * 学会基础操作
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        //Ensure that n is the last element in nums
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        //Ensure that 0 is the first element in nums
        else if (nums[0] != 0) {
            return 0;
        }

        //Once we get here we
        for (int i = 1; i < nums.length; i++) {
            int res = nums[i - 1] + 1;
            if (nums[i] != res) {
                return res;
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;

    }
}
