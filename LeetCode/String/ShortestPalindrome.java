package LeetCode.String;

/**
 * 214. Shortest Palindrome
 * 6/28/2019
 * kmp 没讲
 * 递归
 * 目的： 找出不对称位置 然后进行翻转
 *  i
 *  a   b   c   d
 *  end
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder((s.substring(end + 1))).reverse().toString() + s;
    }
}
