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
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (num != nums[i]) {
                res.add(num + "->" + nums[i]);
            } else {
                // 为什么不是add(num) 变成了string
                res.add(nums[i] + "");
            }
        }
        return res;

    }
}
