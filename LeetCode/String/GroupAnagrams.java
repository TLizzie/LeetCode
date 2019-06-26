package LeetCode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 49. Group Anagrams
 * 6/24/2019
 * 思路： counting sort 存字符出现次数
 * hashmap: counting 为key, string 为value
 *
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count  = new int[26];
            for (Character ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            String s = "";
            for (int i = 0; i < strs.length; i++) {
                if (count[i] != 0) {
                    s += String.valueOf(count[i]) + String.valueOf(i + 'a');
                }
        }
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());

    }

}
