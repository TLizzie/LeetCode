package LeetCode.String;

/**
 * 125. Valid Palindrome
 * 6/27/2019
 * 注意大小写 和 一个新函数 判断当前字符是否是数字或者字母 Character.isLetterOrDigit() //
 * Character.toLowerCase()
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s == null)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            right--;
            left++;
        }
        return true;
    }
}
