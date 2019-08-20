package LeetCode.Array;

/**
 * leetcode 27 removeElement
 * date: 2019/5/13
 * double pointer
 * ???? for loop the boundary condtions always wrong???
 * time complexity O(1)
 * space complexity O(n)
 */

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
