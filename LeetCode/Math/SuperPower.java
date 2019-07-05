package LeetCode.Math;

/**
 * 372, super power
 * 7/4/2019
 * (a * b) % c = (a % c) * (b % c)
 *
 * x ^ y % k = x * x * x * ... * x % k = (x % k) * (x % k) * ...
 * 那么这道题和之前那道Pow(x, n)的解法很类似，我们都得对半缩小，不同的是后面都要加上对1337取余。
 * 由于给定的指数b是一个一维数组的表示方法，我们要是折半缩小处理起来肯定十分不方便，所以我们采用按位来处理，
 * 比如2 ^ 23 = (2 ^ 2) ^ 10 * 2 ^ 3, 所以我们可以从b的最高位开始，算出个结果存入res，然后到下一位是，res的十次方再乘以a的该位次方再对1337取余
 */
public class SuperPower {
    public int superPow(int a, int[] b) {
        int res = 1;
        for (int i = 0; i < b.length; i++) {
            res = pow(res, 10) * pow(a, b[i]) % 1337;
        }
        return res;
    }

    public int pow(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x % 1337;
        return pow(x % 1337, n / 2) * pow(x % 1337, n - n / 2) % 1337;
    }
}
