package LeetCode.Math;

import java.util.HashSet;

/**
 * 202. Happy Number
 * 7/5/2019
 *
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int squareSum, remainder;
        HashSet<Integer> set = new HashSet<>();
        while (set.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remainder = n % 10;
                squareSum += Math.pow(remainder, 2);
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else {
                n = squareSum;
            }
        }
        return false;
    }
}
