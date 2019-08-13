package LeetCode.DFS_BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 310. Minimum Height Trees
 * time: O(n)
 * space: O(n)
 *
 * adj:
     * 0 : 3
     * 1 : 3
     * 2 : 3
     * 3 : 0 1 2 4
     * 4 : 3
 *   * 5 : 4
 *
 * res: [0 1 2 4 5]
 *
 * 层层递进
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<HashSet<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        // undirected graph needs to be added twice
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                res.add(i);
            }
        }

        while (n > 2) {
            n -= res.size();
            List<Integer> leaves = new ArrayList<>();
            for (int i : res) {
                for (int j : adj.get(i)) {
                    adj.get(j).remove(i);
                    if (adj.get(j).size() == 1) {
                        leaves.add(j);
                    }
                }
            }
            res = leaves;
        }
        return res;
    }
}
