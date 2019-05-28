package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 118 PascalsTriangle
 * 动态规划
 * 搞懂list的嵌套定义
 * 2019/5/28
 * time: O(n^2)
 * space: O(n^2)
 * */

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            res.add(new ArrayList<>());
            res.get(i).addAll(list);
        }
        return res;
    }
}
