package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;


/**
 * 784. Letter Case Permutation
 *
 */
public class LetterCasePermutation {

    //backtracking
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        helper(res, s.toCharArray(), 0);
        return res;
    }

    public void helper(List<String> res, char[] s, int start) {
        if (start == s.length) {
            res.add(new String(s));
            return;
        }

        if (Character.isLetter(s[start])) {
            s[start] = Character.toUpperCase(s[start]);
            helper(res, s, start + 1);
            s[start] = Character.toLowerCase(s[start]);
            helper(res, s, start + 1);
        } else {
            helper(res, s, start  + 1);
        }
    }

    //bfs
//    public List<String> letterCasePermutation2(String s) {
//        List<String> res = new ArrayList<>();
//        if (s == null || s.length() == 0)
//            return res;
//
//    }


}
