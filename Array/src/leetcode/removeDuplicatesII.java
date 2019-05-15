package leetcode;

/**
 *  leetcode 80 removeDuplicatesII
 *  date: 2019/5/14
 *  pay attention to the boundary condition
 *  sorted array is provided then just check the nums[i] vs. nums[count]
 *  time complexity  O(n)
 *  space complexity O(1)
 */


public class removeDuplicatesII {
    public static int removeDuplicatesII(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

}
