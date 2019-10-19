package LeetCode.DFS_BFS;

/**
 * 329. Longest Increasing Path in a Matrix
 * time: O(m * n)
 * space: O(m * n)
 */

public class LongestIncreasingPathinaMatrix {
    public int findLongestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int res = 0;

        // cache matrix to store the longest path for each element by far
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int max = dfs(matrix, cache, i, j, Integer.MIN_VALUE);
                res = Math.max(max, res);
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int[][] cache, int i, int j, int min) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= min) {
            return 0;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        min = matrix[i][j];

        // search for the longest path in each direction
        int a = dfs(matrix, cache, i + 1, j, min) + 1;
        int b = dfs(matrix, cache, i - 1, j, min) + 1;
        int c = dfs(matrix, cache, i, j + 1, min) + 1;
        int d = dfs(matrix, cache, i, j - 1, min) + 1;
        int max = Math.max(d, Math.max(c, Math.max(a, b)));
        cache[i][j] = max;
        return max;
    }

}
