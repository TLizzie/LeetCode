package LeetCode.BitManipulation;

/**
 * 389, Find the Difference
 * 7/1/2019
 * 老题
 */

public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
