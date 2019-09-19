package LeetCode.BinarySearch;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * 7、15、2019
 *
 * First, because we are locating the leftmost (or rightmost) index containing target (rather than returning true iff we find target),
 * the algorithm does not terminate as soon as we find a match.
 * Instead, we continue to search until lo == hi and they contain some index at which target can be found.
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
            int left = 0, right = nums.length - 1;
            while(left + 1 < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            if (nums[left] == target)
                return left;
            if (nums[right] == target)
                return right;
            return -1;
        }

        private int findLast(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while(left + 1 < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if (nums[right] == target)
                return right;
            if (nums[left] == target)
                return left;
            return -1;
        }
}
