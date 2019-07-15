package Array.src.leetcode;

import Array.Array;

import java.util.Arrays;

/**
 * 324. Wiggle Sort II
 * 7/12/2019
 * 非常重要
 * 两种方法
 */
public class WiggleSortII {
    /**
     * 排序 找中位数
     * > mid 从左到右 放在奇数位
     * < mid 从右到左 放在偶数位
     * mid 最后放入
     *
     * time: O(nlogn)
     * space: O(n)
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int index = 0;
        int mid = (n - 1) / 2;
        int[] temp = new int[n];

        for (int i = 0; i <= mid; i++) {
            temp[index] = nums[mid - i];
            if (index + 1 < n) {
                temp[index + 1] = nums[n - 1 - i];
            }
            index += 2;
        }
        System.arraycopy(temp, 0 , nums, 0, n);
    }
}
