package LeetCode.Math;

/**
 * 365. Water and Jug Problem
 *
 * 7/4/2019
 *
 * gcd problem
 * 求最大公约数的算法 （贝祖定理）
 * x * m + y * n = z
 * gcd(x, y) * i = z
 *
 */

public class WaterandJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)
            return false;
        if (x == z || y == z || x + y == z)
            return true;
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
