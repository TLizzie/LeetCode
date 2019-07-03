package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78 Subsets
 * 7/1/2019
 * backtracking 回溯算法
 * 非常重要并且常考的一道题
 *
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        helper(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void helper(int[] s, List<List<Integer>> res, List<Integer> list, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < s.length; i++) {
            list.add(s[i]);
            helper(s, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

}

/**
 * intput: [1, 2, 3]
 * output: [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
 * 思考回溯算法是怎么运作的
 */
