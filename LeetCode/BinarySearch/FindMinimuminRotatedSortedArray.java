package LeetCode.BinarySearch;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * 7/16/2019
 *
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[start] <= nums[mid] && nums[mid] >= nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }

    public int findMin2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] < nums[end]) return nums[start];
        return nums[end];
    }
}
