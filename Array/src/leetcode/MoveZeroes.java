package Array.src.leetcode;

/**
 * Leetcode 283. Move Zeroes
 * 6/10/2019
 * in - place operation
 * time: O(n)
 * space: O(1)
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
