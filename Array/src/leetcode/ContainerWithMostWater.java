package leetcode;

/**
 * Leetcode 11 Container With Most Water
 * 5/29
 * double pointer
 * 双指针的题善用 while语句
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            max = Math.max((end - start) * Math.min(height[end], height[start]), max);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
