package LeetCode.BitManipulation;

/**
 * 371. Sum of Two Integers
 * 7/2/2019
 * time : O(1)
 * space: O(1)
 *
 *  0 + 0 = 00
 *  0 + 1 = 01
 *  1 + 0 = 01
 *  1 + 1 = 10   carry 进位
 *
 *
 */
public class SumofTwoIntegers {
    public int sumOfTwoIntegers (int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
