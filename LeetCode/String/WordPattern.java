package LeetCode.String;

import java.util.HashMap;

/**
 * 290. Word Pattern
 * 和205一样
 * time : O(n^2) containsValue 是O(n^2)级别
 * space: O(1)
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] ch = str.split(" ");
        if (ch.length != pattern.length())
            return false;

        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (map.get(pattern.charAt(i)).equals(ch[i]))
                    continue;
                else {
                    return false;
                }
            } else {
                if (map.containsValue(ch[i]))
                    return false;
                else {
                    map.put(pattern.charAt(i), ch[i]);
                }
            }
        }
        return true;
    }
}
