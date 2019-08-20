package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 119 PascalsTriangleII
 * 2019/5/28
 * time: O(n^2)
 * space: O(n^2)
 *
 * */

public class PascalsTrianlgeII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }
        for (int i = 0; i < rowIndex + 1; i++) {
             res.add(0, 1);
             for (int j = 1; j < res.size() - 1; j++) {
                 res.set(j, res.get(j + 1) + res.get(j));
             }
        }
        return res;
    }

  /**
   * * time: O(n^2)
   * space: O(n)
   * */

    public List<Integer> getRow2(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            res.add(new ArrayList<>(list));
        }
        return res.get(rowIndex);
    }
}
