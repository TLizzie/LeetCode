package LeetCode.Math;

/**
 * 343. Integer Break
 * 7/6/2019
 * 2 = 1 + 1
 * 3 = 1 + 2
 * 4 = 2 + 2
 * 5 = 2 + 3
 * 6 = 3 + 3
 * 7 = 3 + 4
 * 8 = 4 + 4
 * 9 = 5 + 4
 * 10 = 6 + 4
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2 || n == 3)
            return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
