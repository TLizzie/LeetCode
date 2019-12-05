package LeetCode.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        int rotten = 0;
        int res = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rotten++;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 2 || grid[x][y] == 0) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    fresh--;
                }
            }
        }

        return fresh == 0 ? res - 1 : -1;
    }
}
