package LeetCode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 30. Substring with Concatenation of All Words
 * 8/1/2019
 * 实现题
 * time:  O(n ^ 2)
 * space: O(n)
 */
public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int n = words.length;
        int m = words[0].length();
        // 当检验到剩余位置后可以停止 不必一直到最后 很关键 忘记等号就无法ac
        for (int i = 0; i <= s.length() - m * n; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n;
            int j = i;
            while (k > 0) {
                String str = s.substring(j, j + m);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                k--;
                j += m;
            }
            if (k == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
