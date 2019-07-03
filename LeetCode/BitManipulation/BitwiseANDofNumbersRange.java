package LeetCode.BitManipulation;

/**
 * 201. Bitwise AND of Numbers Range
 * 7/2/2019
 *
 * 思路：
 * 因为是连续的数字，因此最后一位相与一定是0 （奇偶相间）
 * 因此每次都右移一位 直到找到完全相同的高位
 * 高位+ 右移次数个0 = 最终结果
 * time : O(1)
 * space: O(1)
 */

public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return m << offset;
    }
}
