package LeetCode.String.Palindrome;

import java.util.HashSet;

/**
 * 266.Palindrome Permutation
 * 6/28/2019
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Input: "code"
 * Output: false
 *
 * Input: "aab"
 * Output: true
 *
 * Input: "carerac"
 * Output: true
 */
public class PalindromePermutation {
    public boolean canPermutePalidrome(String s) {
        HashSet<Character> res = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (res.contains(s.charAt(i))) {
                res.remove(s.charAt(i));
            } else {
                res.add(s.charAt(i));
            }
        }
        return res.size() <= 1;
    }

    public boolean canPermutePalidrome2(String s) {
        char[] count = new char[256];
        int res = 0;
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
            } else {
                count[c]++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                res++;
        }
        return res <= 1;
    }
}
