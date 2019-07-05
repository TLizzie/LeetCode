package LeetCode.Math;

/**
 * 204. Count Primes
 * 7/4/2019
 * 厄拉多塞筛查法， 求一组质数，时间复杂度仅为 O(nlognlogn)
 * 如果从1 到n-1分别判断质数，时间复杂度为 O(nsqrt(n))
 *  1  2  3  4  5  6  7  8  9 10
 * 11 12 13 14 15 16 17 18 19 20
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] pri = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (pri[i] == false)
                res++;
            for (int j = 2; j * i < n; j++) {
                pri[i * j] = true;
            }
        }
        return res;
    }
}
