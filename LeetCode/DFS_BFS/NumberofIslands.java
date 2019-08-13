package LeetCode.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200 num of islands
 * 8/6/2019
 * floodfill algorithm
 * time: O(k * n * m) k: num of 1s
 * space: O(k)  (stack) O(m * n) worst
 * counting the num of 1s
 *
 */
public class NumberofIslands {

    private int m;
    private int n;

    public int numberOfIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int res = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    floodFill(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    //dfs
    public void floodFill(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        floodFill(grid, i, j + 1);
        floodFill(grid, i, j - 1);
        floodFill(grid, i - 1, j);
        floodFill(grid, i + 1, j);
    }


    //bfs

    /**
     * time: O(k * n * m) k: num of 1s
     *  * space: 具体分析
     * @param grid
     * @param x
     * @param y
     */
    public void floodFill2(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * n + y); //将二维变成一维队列
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / n;
            int j = cur % n;
            if (i > 0 && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * n + j);
                grid[i - 1][j] = '0';
            }
            if (i < m - 1 && grid[i + 1][j] == '1') {
                queue.offer((i + 1) * n + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                queue.offer(i * n + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < n - 1 && grid[i][j + 1] == '1') {
                queue.offer(i * n + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }
}
