package LeetCode.Array;

/**
 * leetcode 26 removeDuplicates
 * date: 2019/5/13
 * double pointer
 *  ??? what if count is not starting from 1
 *  time complexity O(n)
 *  space complexity O(1)
 */

class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {     // throw an exception
            return 0;
        }
        int count = 1;                              // no need to check the first element
        for (int i = 1; i < nums.length; i++) {     // remember to check the range of for loop
            if (nums[i] != nums[i - 1]) {           // it is not equal to check the two elements are duplicated.
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}


