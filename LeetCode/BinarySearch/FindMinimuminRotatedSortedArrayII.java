package LeetCode.BinarySearch;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * 7/15/2019
 *
 */
public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                // 面对[2,2,2,0,1,2] 这样的数组
                end--;
            }
        }
        if (nums[start] < nums[end])    return nums[start];
        else return nums[end];
    }
}
