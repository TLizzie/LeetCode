package LeetCode.Array;

/**
    * Leetcode 389 FindtheDifference
    * 5/29
    * bitwise manipulation
    *
 */

public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        char res = t.charAt(s.length() - 1);
        for (int i = 0; i < s.length(); i++) {
             res ^= s.charAt(i) ^ t.charAt(i);
        }
        return res;
    }
}
