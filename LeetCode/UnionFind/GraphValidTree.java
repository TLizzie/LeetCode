package LeetCode.UnionFind;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 261 graph valid tree
 * time: O(nodes * edges)
 * space: O(n)
 *
 *  n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 *
 *    3 - 0 - 1 - 4
 *        |
 *        2
 *
 *  0 : 1 2 3
 *  1 : 0 4
 *  2 : 0
 *  3 : 0
 *  4 : 1
 *
 *  n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 *
 *          4
 *          |
 *      0 - 1 - 3
 *          |  /
 *          2
 *
 *  0 : 1
 *  1 : 0 2 3 4
 *  2 : 1 3
 *  3 : 1 2
 *  4 : 1
 */
public class GraphValidTree {
    //union find
    public boolean validTree(int n, int[][] edges) {

    }

    //dfs
    public boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> graph = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        HashSet<Integer> visisted = new HashSet<>();
        visisted.add(0);

        boolean res = helper(graph, visisted, 0 ,  -1);
        if (res == false)
            return false;

        // 判断dfs是否有孤立的点未被遍历到
        return visisted.size() == n;
    }

    private boolean helper(List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent) {
        List<Integer> sub = graph.get(node);
        for (int v : sub) {
            if (v == parent) continue;
            if (visited.contains(v)) {
                return false;
            }
            visited.add(v);
            boolean res = helper(graph, visited, v, node);
            if (res == false)
                return false;
        }
        return true;
    }



}
