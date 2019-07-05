package LeetCode.Math;

/**
 * 66. plus one
 * 7/3/2019
 * 加法进位 从末位开始
 */
public class PlusOne {
    public int[] plusOne(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < 9) {
                nums[i]++;
                return nums;
            } else {
                nums[i] = 0;
            }
        }

        int[] res = new int[nums.length + 1];
        res[0] = 1;
        return res;
    }
}
