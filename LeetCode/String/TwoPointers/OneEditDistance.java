package LeetCode.String.TwoPointers;

/**
 * 161. One Edit Distance
 * two pointers
 * time : O(n)
 * space: O(1)
 */
public class OneEditDistance {
    public boolean oneEditDistance(String s, String t) {
        if (s == null || t == null)
            return false;

        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        int i = 0, j = 0;
        int count = 0;
        while (i < s.length() && j < t.length()) {
            if(s.charAt(i) != t.charAt(j)) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (s.length() > t.length()) {
                    j--;
                }
                if (s.length() < t.length()) {
                    i--;
                }
            }
            i++;
            j++;
        }
        return count == 0 && s.length() != t.length() || count == 1;
    }

    public boolean isOneEditDistance2(String s, String t) {
        if (s == null || t == null)
            return false;
        if (Math.abs(s.length() - t.length()) > 1)
            return false;

        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
