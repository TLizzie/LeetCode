package LeetCode.Matrix;

/**
 *  59. Spiral Matrix II
 *  7/11/2019
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int val = 1;
        int[][] res = new int[n][n];
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = val++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = val++;
            }
            colEnd--;

            if (rowStart <= rowEnd && colStart <= colEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    res[rowEnd][i] = val++;
                }
                rowEnd--;
            }

            if (rowStart <= rowEnd && colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    res[i][colStart] = val++;
                }
                colStart++;
            }
        }
        return res;
    }
}
