package LeetCode.String;

/**
 * 242. Valid Anagram
 * 6/24/2019
 * counting sort
 * hashmap
 *
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] res = new int[256];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
            res[t.charAt(i) - 'a']--;
        }

        for (int i : res) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
