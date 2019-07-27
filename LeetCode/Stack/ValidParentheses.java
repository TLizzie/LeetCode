package LeetCode.Stack;

/**
 * 7/24/2019
 * 基本的压栈匹配
 *
 */

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                // 如果没有对应的
                if (stack.isEmpty() || ch != stack.pop())
                    return false;
            }
        }
        // 判断是否数量对称
        return stack.isEmpty();
    }
}
