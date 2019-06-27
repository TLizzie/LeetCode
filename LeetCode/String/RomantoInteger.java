package LeetCode.String;

/**
 * 13. Roman to Integer
 * 6/26/2019
 * 规律： 如果左边数字小于右边数字， 那么就是 右 - 左
 * time : O(n)
 * space : O(1)
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        if (s.length() == 0 || s == null)
            return 0;
        int res = convert(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (convert(s.charAt(i - 1)) < convert(s.charAt(i))) {
                res += convert(s.charAt(i)) - convert(s.charAt(i - 1)) * 2;
            } else {
                res += convert(s.charAt(i));
            }
        }
        return res;
    }
    private static int convert(char c) {
        int res = 0;
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return res;
    }
}
