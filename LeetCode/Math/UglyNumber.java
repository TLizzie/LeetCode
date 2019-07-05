package LeetCode.Math;

/**
 * 7/4/2019
 * 263. ugly number
 * time: O(1)
 * space:  O(1)
 */
public class UglyNumber {
    public boolean uglyNumber(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
}
