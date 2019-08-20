package LeetCode.Array;
/**
 * Leetcode 376. Wiggle Subsequence
 *  * 用up[i]和down[i]分别记录到第i个元素为止以上升沿和下降沿结束的最长“摆动”
 *  * 序列长度，遍历数组，如果nums[i]>nums[i-1]，表明第i-1到第i个元素是上升的，
 *  * 因此up[i]只需在down[i-1]的基础上加1即可，而down[i]保持down[i-1]不变；
 *  * 如果nums[i] < nums[i-1]，表明第i-1到第i个元素是下降的，因此down[i]
 *  * 只需在up[i-1]的基础上加1即可，而up[i]保持up[i-1]不变；如果nums[i]==nums[i-1]，
 *  * 则up[i]保持up[i-1]，down[i]保持down[i-1]。比较最终以上升沿和下降沿结束的
 *  * 最长“摆动”序列长度即可获取最终结果
 *  */

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }
    /**上述简化版 贪心算法
    time： O（n）*/
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int p = 1, q = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                p = q + 1;
            } else if (nums[i] < nums[i - 1]) {
                q = p + 1;
            }
        }
        return Math.min(n, Math.max(p,q));
    }

}
