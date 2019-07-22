package LeetCode.BinarySearch;

/**
 * 300. Longest Increasing Subsequence
 * 7/8/2019
 * Binary Search
 * i, j 相当于 tails 的起点 终点
 * res相当于 tail的实际长度
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] tails = new int[nums.length];

        for (int num : nums) {
            int i = 0, j = res;
            while (i != j) {
                int mid = i + (j - i) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (i == res) res++;
        }
        return res;
    }
}
