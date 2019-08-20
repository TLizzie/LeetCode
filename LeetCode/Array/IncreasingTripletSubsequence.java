package LeetCode.Array;

/**
 * Leetcode 334 Increasing Triplet Subsequence
 * 5/31/2019
 * 目的：寻找倒数第二小的值 看是否有比倒数第二小的值还小的数字存在
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < min) {
                min = i;
            } else if (i <= min2) {
                min2 = i;
            } else if (i > min2) {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        if (nums.length < 3 || nums == null) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= small) {
                small = i;
            } else if (i <= big) {
                big = i;
            } else {
                return true;
            }
        }
        return false;
    }
}
