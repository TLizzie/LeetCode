package LeetCode.BitManipulation;

/**
 * 190. Reverse Bits
 * 7/1/2019
 * bit manipulation
 * 思路：
 * 每次更新一位 先将res 左移一位
 * if语句判断 n的奇偶性 如果是奇数 则+1
 * 用移位操作会比除法效率更高
 */

public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) == 1)
                res++;
            n >>= 1;
        }
        return res;
    }
}
