package LeetCode.String;

import java.util.HashMap;

/**
 * 387. First Unique Character in a String
 * 6/22/2019
 * hashmap
 * time : O(n)
 * space : O(n)
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        HashMap<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
             if (!res.containsKey(s.charAt(i))) {
                 res.put(s.charAt(i), 1);
             } else {
                 res.put(s.charAt(i), res.get(s.charAt(i)) + 1);
             }
        }
        for (int i = 0; i < s.length(); i++) {
            if (res.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    /**
     * 没写出来的brute force
     */
    public int firstUniqChar3(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean isUnique = true;
            for (int j = 0 ; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique)
                return i;
        }
        return -1;
    }
}
