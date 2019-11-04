package LeetCode.String;

import com.sun.tools.javac.util.List;

import java.util.*;

/**
 * 1181. Before and After Puzzle
 * Input: phrases = ["writing code","code rocks"]
 * Output: ["writing code rocks"]
 *
 * Input: phrases = ["a","b","a"]
 * Output: ["a"]
 *
 * space: O(n)
 * time: O(nlogn)
 */
class BeforeandAfterPuzzle {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
//        if (phrases == null || phrases.length == 0)
//            return new ArrayList<>();

        int n = phrases.length;
        // start word: <String, List<Index>>
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(head(phrases[i]))) {
                map.put(head(phrases[i]), new ArrayList<>());
            }
            map.get(head(phrases[i])).add(i);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String tail = tail(phrases[i]);
            if (map.containsKey(tail)) {
                for (Integer j : map.get(tail)) {
                    if (i != j) {
                        set.add(phrases[i] + phrases[j].substring(tail.length()));
                    }
                }
            }
        }

        List<String> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }

    public String head(String s) {
        String[] str = s.split(" ");
        return str[0];
    }

    public String tail(String s) {
        String[] str = s.split(" ");
        return str[str.length - 1];
    }

}
