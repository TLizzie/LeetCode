package LeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class Triangle {
//    top down
    public int minimalTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }
        int n = triangle.size();
        int[][] minTotal = new int[n + 1][n + 1];
        for (int[] min : minTotal) {
            Arrays.fill(min, Integer.MAX_VALUE);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
//                corner cases
                minTotal[i][j] = triangle.get(i - 1).get(j - 1);
                if (i == 1 && j == 1) {
//                    minTotal[i][j] += minTotal[i - 1][j];
                    continue;
                }
                if (j == 1) {
                    minTotal[i][j] += minTotal[i - 1][j];
                }  else if (i == j) {
                    minTotal[i][j] += minTotal[i - 1][j - 1];
                } else {
                    minTotal[i][j] += Math.min(minTotal[i - 1][j], minTotal[i - 1][j - 1]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : minTotal[n]) {
            res = Math.min(res, i);
        }
        return res;
    }
    
    
}
