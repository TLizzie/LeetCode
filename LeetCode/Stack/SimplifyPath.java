package LeetCode.Stack;

import java.util.Stack;
/**
 * 7/24/2019
 * 基本的压栈匹配
 * 71. Simplify Path
 */

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");
        for (String str : paths) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.equals(".") && !str.equals("")) {
                stack.push(str);
            }
        }

        String res = "";
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res;
    }
}
