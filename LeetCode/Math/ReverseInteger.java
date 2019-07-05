package LeetCode.Math;

/**
 * 7. reverse Integer
 * 7/2/2019
 * 溢出问题
 * time: O(1)
 * space: O(1)
 */
public class ReverseInteger {
    public int reverseInteger(int num) {
        long res = 0;                       // 定义一个long防止res溢出
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)     // 判断res是否溢出
                return 0;
        }
        return (int)res;        // 强制转换
    }

    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int cur = res;
            res = res * 10 + x % 10;
            x /= 10;
            if (res / 10 != cur)
                return 0;
        }
        return res;
    }
}
