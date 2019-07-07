package LeetCode.Math;

/**
 * 396. Rotate Function
 * 7/6/2019
 * F(k) = sum - nBk[0]
 *
 * F(k) = F(k - 1) + sum - nBk[0]
 *
 */
public class RotateFunction {
    public int rotateFunction(int[] A) {
        int sum = 0;
        int candidate = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            candidate += A[i] * i;
        }
        int res = candidate;
        for (int i = A.length - 1; i >= 0; i--) {
            candidate = candidate + sum - A[i] * A.length;
            res = Math.max(res, candidate);
        }
        return res;
    }
}
