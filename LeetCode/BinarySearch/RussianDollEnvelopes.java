package LeetCode.BinarySearch;

import java.util.Arrays;

/**
 * 154. Russian Doll Envelopes
 * 7/16/2019
 * 排序算法 宽高都是升序排列
 * 宽度从小到大， 高度从大到小进行排序
 * 重写Arrays.sort 宽相等 高倒叙排 找最大值
 * 宽度： 最长递增序列
 *
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int[] envelope : envelopes) {
            int i = binarySearch(dp, 0, res, dp[1]);
            dp[i] = dp[1];
            if (i == res) {
                res++;
            }
        }
        return res;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] >= target)  return start;
        return end;
    }
}
