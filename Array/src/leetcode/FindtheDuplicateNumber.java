package Array.src.leetcode;
/**
 * Leetcode 287. Find the Duplicate Number
 * 6/1/2019
 *
 */

import java.util.HashSet;
import java.util.Set;

public class FindtheDuplicateNumber {

    //Hashset 方法需要熟练
    // time: O(n)
    // space: O(n)
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }

    // 二分查找
    // time: O(logn)
    // space: O(1)
    public int findDuplicate2(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int mid = (max - min) / 2 + min;
            int count = 0;
            // 计算总数组中有多少个数小于等于中间数
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            // 如果小于等于中间数的数量大于中间数，说明前半部分必有重复
            if (count > mid) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
