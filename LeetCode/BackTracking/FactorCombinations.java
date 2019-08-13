package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

/**
 * 254. factor combinations
 * 8/7/2019
 *
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * Note:
 *
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Example 1:
 * Input: 1
 * Output: []
 *
 * Example 2:
 * Input: 37
 * Output:[]
 *
 * Example 3:
 * Input: 12
 * Output:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 *
 * Example 4:
 * Input: 32
 * Output:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 */

    //time: O(nlogn)
    //space:O(logn)
public class FactorCombinations {
    public List<List<Integer>> getFators(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, 2);
        return res;
    }
    //递归，为了防止2,2,3和2,3,2这种重复，参数里需要一个start
    private void helper(List<List<Integer>> res, List<Integer> list,  int n, int start) {
        if (n == 1) {
            //size>1不是因为要排除质数，而是为了排除任意数把自己当做一个因数返回。
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                helper(res, list, n / i, i);
                list.remove(list.size() - 1);
            }
        }
    }

}
