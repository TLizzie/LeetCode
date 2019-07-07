package LeetCode.Math;

/**
 * 400. Nth Digit
 * 7/5/2019
 *
 */
public class NthDigit {
    public int findNthDigit(int n) {
        int start = 1;
        long count = 9;
        int len = 1;
        while (n > count * len) {
            n -= count * len;
            len++;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = Integer.toString(start);
        return s.charAt((n - 1) % len) - '0';
    }
}
