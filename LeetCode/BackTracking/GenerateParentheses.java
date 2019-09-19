package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22 Generate Parentheses
 * 卡特兰数
 * backtracking
 *
 * time: O(2^ n)
 * spack: O(n)
 *
 * 判定条件：左边一定要比右边少  没有未闭合的左边不可以加右边
 *
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0)
            return res;
        helper(res, "", n, n);
        return res;
    }

    public void helper(List<String> res, String s, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }

        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }

        if (right > 0) {
            helper(res, s + ")", left, right - 1);
        }
    }
}
