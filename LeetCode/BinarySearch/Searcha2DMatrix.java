package LeetCode.BinarySearch;

/**
 * 74. Search a 2D Matrix
 * 7/15/2019
 *
 * 要记住：
 * value = matrix[mid / col][mid % col]
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int value = matrix[mid / col][mid % col];
            if (value == target) {
                return true;
            } else if (value > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
