package LeetCode.String;

import java.util.HashMap;

/**
 * 294.Flip Game II
 * 6/24/2019
 *
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to determine if the starting player can guarantee a win.
 * Input: s = "++++"
 * Output: true
 * Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+"
 *
 * time: O(2^n)
 * space: O(2^n)
 *
 */
public class FlipGameII {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0)
            return false;
        HashMap<String, Boolean> map = new HashMap<>();     //创立一个HashMap来存储过往的结果
        return helper(s, map);
    }

    private boolean helper(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s))
            return map.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String oppo = s.substring(0, i) + "--" + s.substring(i + 2);
        }
            if (!helper(s, map)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
