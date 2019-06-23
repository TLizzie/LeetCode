package LeetCode.String;

/**
 * Leetcode 58. Length of Last Word
 * 6/22/2019
 * brute force
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
