package LeetCode.BitManipulation;

/**
 * 191. Number of 1 Bits
 * 7/1/2019
 * 最低位改为0
 * n &= (n - 1)
 */
public class Numberof1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;       // 判断奇偶，奇数末位为1， 则加一个 1 才明白
            n >>= 1;
        }
        return res;
    }
}
