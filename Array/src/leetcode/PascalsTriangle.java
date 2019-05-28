package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 118 PascalsTriangle
 * 动态规划
 * 搞懂list的嵌套定义
 * res.add (new ArrayList(list)) 如果写成res.add(list) 是添加了地址的引用，如果list集合里面有变化那么添加的东西也会变
 * 每次add() 一个new的内存空间，那么之前set的内存空间改变就不受影响
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
