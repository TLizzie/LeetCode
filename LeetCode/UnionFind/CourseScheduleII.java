package LeetCode.UnionFind;

import java.util.*;

/**
 * 210. Course Schedule II
 * 8/9/2019
 * time: O(V + E)
 * space: O(n)
 *
 */
public class CourseScheduleII {
    public int[] findOrderdfs(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
        }

        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            visited.put(i, 0);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited.get(i) == 0) {
                if (!helper(graph, visited, res, i)) {
                    return new int[0];
                }
            }
        }


        // 判断是否存在环
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(numCourses - 1 - i);
        }
        return result;
    }

    private boolean helper(List<List<Integer>> graph, HashMap<Integer, Integer> visited, List<Integer> res, int i) {
        if (visited.get(i) == 1) {
            return false;
        }
        if (visited.get(i) == 2) {
            return true;
        }
        visited.put(i, 1);
        for (int j : graph.get(i)) {
            if (!helper(graph, visited, res, j)) {
                return false;
            }
        }
        visited.put(i, 2);
        res.add(i);
        return true;
    }


    public int[] findOrderbfs(int numCourses, int[][] prerequisites) {

        int[] res = new int[numCourses];
        int k = 0;
        /**
         * 计算入度
         */
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                        res[k++] = pair[0];
                    }
                }
            }
        }


        return k == numCourses ? res : new int[0];

    }

}
