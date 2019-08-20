package LeetCode.Array;

/**
 * Leetcode 42
 * 5/29
 * double pointer
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left];
                left++;
            }
            else {
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
