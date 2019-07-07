package LeetCode.Math;

/**
 * 397. Integer Replacement
 * 7/6/2019
 */
public class IntegerReplacement {
    // bit manipulation
    /**
     * 如果倒数第二位是0 那么 N-1比N+1 能消掉更多的1
     * 如果倒数第二位是1 那么 N + 1 比N - 1更多的1
     *
     * 1001 + 1 = 1010
     * 1001 - 1 = 1000
     *
     * 1011 + 1 = 1100
     * 1111 + 1 = 10000
     */
    public int integerReplacement(int n) {
        long N = n;
        int res = 0;
        while (N != 1) {
            if (N % 2 == 0) {
                N >>= 1;
            } else {
                if (N == 3) {
                    res += 2;
                    break;
                }
                N = (N & 2) == 2 ? N + 1 : N - 1;
                res++;
            }
        }
        return res;
    }

    /**
     * n = 2k + 1
     * n + 1 = 2k + 2   k + 1
     * n - 1 = 2k       k
     *
     * 9
     * 10 5 3 1
     * 8 4 2 1
     * @param n
     * @return
     *
     * time : O(logn) %2 接近
     * space: O(1)
     */
    public int integerReplacement2(int n) {
        if (n == Integer.MAX_VALUE) return 32;          // 越界处理
        int res = 0;
        while (n != 1) {
            if (n % 2 == 0)
                n /= 2;
            else {
                if ( (n + 1) % 4 == 0 && (n - 1 != 2)) {        // 3 的特殊处理
                    n++;
                } else {
                    n--;
                }
            }
            res++;
        }
        return res;

    }

}
