package LeetCode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 293. Flip Game
 * 6/24/2019
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 * For example, given s = "++++", after one move, it may become one of the following states:
 *
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 *
 * If there is no valid move, return an empty list [].
 *
 * time: O(n)
 * space: O(n)
 */
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {     //一定有两个字符才能开始游戏
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+')
                res.add(s.substring(0, i - 1) + "--" + s.substring((i + 1), s.length()));
        }
        return res;
    }

}
