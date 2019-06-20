package LeetCode.String;

/**
 * Leetcode 28. Implement strStr()
 * 6/19/2019
 * brute force
 * time : O(m * n)
 * space : O(1)
 */
public class ImplementstrStr {
    public int strStr(String haychack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        for (int i = 0; i < haychack.length(); i++) {
            if (needle.length() + i > haychack.length())
                break;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haychack.charAt(j + i))
                    break;
                if (j == needle.length() - 1)
                    return i;
            }
        }
        return -1;
    }
}
