package Array.src.leetcode;

/**
 * 80. Remove Duplicates from Sorted Array II
 * 7/8/2019
 * pay attention to the boundary condition
 * sorted array is provided then just check the nums[i] vs. nums[count]
 * time complexity  O(n)
 * space complexity O(1)
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums.length;
        int count = 2;
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
