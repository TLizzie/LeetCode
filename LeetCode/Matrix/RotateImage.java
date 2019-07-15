package LeetCode.Matrix;

/**
 * 48. Rotate Image
 * 7/11/2019
 * 90度翻转 ：
 * 先沿着主对角线翻转
 * 然后中线翻转
 *
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {            //注意中线翻转的j起始位置
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {           //
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
