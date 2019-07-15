package LeetCode.BinarySearch;

/**
 * leetcode 33 Search in Rotated Sorted Array
 * 7/11/2019
 *  *
 *  * binary search
 *  * 问题： 临界判断条件为啥是这个？？
 *
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target)  return start;
        if (nums[end] == target)    return end;
        return -1;
    }

    public int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }


}
