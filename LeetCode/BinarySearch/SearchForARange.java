package LeetCode.BinarySearch;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * 7、15、2019
 */
public class SearchForARange {

        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return new int[]{-1, -1};
            int start = findFirst(nums, target);
            if (start == -1)
                return new int[]{-1, -1};
            int end = findLast(nums, target);
            return new int[]{start, end};
        }

        private int findFirst(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (end - start) / 2 + start;
                if (nums[mid] == target) {
                    return start;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return -1;
        }

        private int findLast(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (end - start) / 2 + start;
                if (nums[mid] == target) {
                    return end;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return -1;
        }


}
