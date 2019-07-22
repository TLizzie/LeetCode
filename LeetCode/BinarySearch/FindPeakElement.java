package LeetCode.BinarySearch;

/**
 * 162. Find Peak Element
 * 7/15/2019
 * 如果找到了mid 那么无需再往后找 只需判断前面元素是否合格
 * 如果不合格 那么就继续往下找
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] > nums[end])
            return start;
        return end;
    }
}
