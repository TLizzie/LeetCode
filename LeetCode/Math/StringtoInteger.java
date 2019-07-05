package LeetCode.Math;

/**
 *  8. String to Integer (atoi)
 *  7/3/2019
 * 思路：
 * 1. 首先 trim string
 * 2. 判断正数负数 提取负号
 * 3. 判断是否有是数字 如果不是返回结果
 * 4. 判断是否res是否越界
 *
 * time ：O(n)
 * space: O(1)
 */

public class StringtoInteger {
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0)
            return 0;
        long res = 0;
        int sign = 1;
        int start = 0;

        if (str.charAt(0) == '-') {
            sign = -1;
            start++;
        } else if (str.charAt(0) == '+') {
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) res * sign;
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;

        }
        return (int) res  * sign;
    }

}
