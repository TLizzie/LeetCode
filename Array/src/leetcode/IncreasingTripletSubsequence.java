package Array.src.leetcode;

/**
 * Leetcode 334 Increasing Triplet Subsequence
 * 5/31/2019
 *
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

    public boolean increasingTriplet(int[] nums) {
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
