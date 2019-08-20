package LeetCode.Array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Leetcode 128 Longest Consecutive Sequence
 * 5/31
 * Arraysort
 * Hashset
 *
 */
public class LongestConsecutiveSequence {

    //Arraysort
    // time : O(nlogn)
    //space: O(n)
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int res = 1;
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]){
                if (nums[i] == nums[i - 1] + 1) {
                    current += 1;
                }
                else {
                    res = Math.max(res, current);
                    current = 1;
                }
            }
        }
        return Math.max(res, current);

    }

    //HashSet
    //time : O(n)
    //space: O(n)
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }

            int up = nums[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }

            res = Math.max(res, up - down - 1);
        }

        return  res;
    }
}
