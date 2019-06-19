package Array.src.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 228. Summary Ranges
 * brute force
 * time : O(n)
 * space : O(n)
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (num != nums[i]) {
                res.add(num + "->" + nums[i]);
            } else {
                res.add(nums[i] + "");
            }
        }
        return res;

    }
}
