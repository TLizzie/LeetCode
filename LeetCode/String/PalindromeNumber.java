package LeetCode.String;

/**
 * Leetcode 9 Palindrome Number
 * 6/5/2019
 * 需要会基本方法 如何将int转成字符串
 *
 * String str = new String("");
 * str.stringOfvalue(x);
 *
 * 这种题思路 取余 边界条件0 10的倍数……
 * 
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0)
            return false;
        int rev = 0;
        int palin = x;
        while (palin > 0) {
            rev = rev * 10 + palin % 10;
            palin /= 10;
        }
        return x == rev;
    }
}
