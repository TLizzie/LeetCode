package LeetCode.Array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * LeetCode 217
 * 5/29
 * Hashset API 基本都是返回的boolean型
 *
 */
public class ContainsDuplicate {

    //HashSet
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!res.add(nums[i]))
                return true;
        }
        return false;
    }

    //Sorting
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

}
