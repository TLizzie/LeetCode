package leetcode;

/**
 * leetcode 189 Rotate Array
 * date: 2019/5/14
 * two ways to solve the problem
 * ??? reverse the array still not
 * ??? need to figure out how to do the remainder calculation
 * time complexity O(n)
 * space complexity O(n)
 */

//public class rotate {
//    public static void rotate(int[] nums, int k) {
//        int[] temp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            temp[(i + k) % nums.length] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = temp[i];
//        }
//;    }
//}

/** another way to solve the problem
 * time O(n)
 * space O(1)
 */

public class rotate {

    public static void reverse(int[] nums, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}