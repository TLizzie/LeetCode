package LeetCode.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
//        record the visited nodes
//        0: never visited
//        1: visited
//        -1: next layer
        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length != 0 && visited[i] == 0) {
                visited[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int j : graph[cur]) {
                        if (visited[j] == 0) {
                            visited[j] = visited[cur] == 1 ? -1 : 1;
                            queue.offer(j);
                        } else {
                            if (visited[cur] == visited[j]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
