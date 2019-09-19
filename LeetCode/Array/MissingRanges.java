package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 163.Missing Ranges
 * 7/9/2019
 *
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 *
 * Example:
 *
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 *
 * 注意 要考虑溢出的问题
 *
 *      [2147483647] 0 2147483647
 *      ["0->2147483646"]
 *      ["0->2147483646","-2147483648->2147483647"]
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long alower = (long)lower;
        long aupper = (long)upper;

        for (int num : nums) {
            if (num == alower) {
                alower++;
            } else if (alower < num) {
                if (alower + 1 == num) {
                    res.add(String.valueOf(alower));
                } else {
                    res.add(alower + "->" + (num - 1));
                }
                alower = (long)num + 1;
            }
        }
        if (alower == upper) {
            res.add(String.valueOf(alower));
        } else if (alower < upper) {
            res.add(alower + "->" + aupper);
        }
        return res;
    }
}
