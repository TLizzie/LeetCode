package LeetCode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode 219 Contains Duplicate II
 * 5/29
 * Hashset API 基本都是返回的boolean型
 */
public class ContainsDuplicatesII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(nums[i])) {
                if (i - res.get(nums[i]) <= k)
                    return true;
            }
            res.put(nums[i], i);
        }
        return false;
    }
}
