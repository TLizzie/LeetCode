package LeetCode.BinarySearch;

/**
 * 240. Search a 2D Matrix II
 * The idea here is to search from the rightmost node of the highest row. For this cell, cells on the left of it are smaller than it,
 * cells below are bigger than it. So each time, a row or a column can be removed from consideration.
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;

        while (col >= 0 && row <= matrix.length - 1) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
