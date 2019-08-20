package LeetCode.Array;

import java.util.Arrays;

/**
 * Leetcode 280. Wiggle sort
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]...
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 */
public class WiggleSort {

    // sort the array and swap the two adjacent elements
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2) return;
        for (int i = 2; i < nums.length; i += 2) {
            swap(nums, nums[i], nums[i - 1]);
        }
    }
    public void swap(int[] nums, int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    /**
     * 当i为奇数时，nums[i] >= nums[i - 1]
     * 当i为偶数时，nums[i] <= nums[i - 1]
     */

    public void wiggleSort2(int[] nums) {
        if (nums.length < 2)
            return;
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] <= nums[i - 1] || i % 2 == 0 && nums[i] > nums[i - 1]) {
                swap(nums, nums[i], nums[i - 1]);
            }
        }
    }
}
