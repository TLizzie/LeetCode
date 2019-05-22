package leetcode;

/**
 * Leetcode 55 JumpGame
 * 贪心算法
 * 看每个元素最远能走多少
 * space: O(1)
 * time : O(n)
 */
public class JumpGame {
    public static boolean JumpGame(int nums[]) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}
