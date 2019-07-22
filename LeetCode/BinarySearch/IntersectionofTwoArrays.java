package LeetCode.BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349.  Intersection of Two Arrays
 * 7/15/2019
 *
 */
public class IntersectionofTwoArrays {

    // use two hashsets
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[]{};
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        Set<Integer> intersect = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }

        int[] res = new int[intersect.size()];
        int i = 0;
        for (int num : intersect) {
            res[i++] = num;
        }
        return res;
    }

    // binary search
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[]{};
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        for (int num : nums2) {
            if (binarySearch(nums1, num)) {
                set.add(num);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            res[i++] = num;
        }
        return res;
    }

    private boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

}
