package Array.src.leetcode;
/**
 * Leetcode 209 Minimum Size Subarray Sum
 * 6/18/2019
 * selecting window
 * time: O(n)
 * space: O(1)
 */
public class MinimumSizeSubarraySum {
    // selecting window
    /**
     * [0 1 2 3 4 5]
     *  2 3 2 2 4 3
     *  [    ]
     *  sum   left   res
     *  keep一个最小的window长度使得 sum >= s
     */
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0, left = 0;
        for (int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s && left <= i) {
                res = Math.min(res, i - left + 1);   // length of the res
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    //binary search
    /**
     * 思路是，我们建立一个比原数组长一位的 sums 数组，其中 sums[i] 表示 nums 数组中 [0, i - 1] 的和，
     * 然后我们对于 sums 中每一个值 sums[i]，用二分查找法找到子数组的右边界位置，使该子数组之和大于 sums[i] + s，然后我们更新最短长度的距离即可。
     *  * binary search
     *  * time : O(log n)
     *  * space: O(n)
     */
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int res = nums.length + 1;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int right = searchRight(i + 1, nums.length, sum[i] + s, sum);
            if (right == nums.length + 1)
                break;
            if (res > right - i)
                res = right - i;
        }
        return res == nums.length + 1 ? 0 : res;

        public int searchRight(int left, int right, int key, int nums[]) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= key) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;


    }
}
