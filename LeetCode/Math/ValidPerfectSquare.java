package LeetCode.Math;

/**
 * 367. Valid Perfect Square
 * 7/3/2019
 * 面试常考
 *
 */

public class ValidPerfectSquare {

    // binary search
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while (start <= end) {
            long mid = start + (end - start) / 2;   // 注意防止mid溢出
            if (mid * mid == num)
                return true;
            else if (mid * mid > num) {
                end = (int)mid - 1;
            } else if (mid * mid < num) {
                start = (int)mid + 1;
            }
        }
        return false;
    }

    // n * n > num
    public boolean isPerfectSquare2(int num) {
        if (num < 0) return false;
        if (num == 1) return true;
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num)
                return true;
        }
        return false;
    }

    //牛顿法
    public boolean isPerfectSquare3(int num) {
        long x = num;
        while (x * x > num) {
            x = (num / x + x) / 2;
        }
        return x * x == num;
    }


}
