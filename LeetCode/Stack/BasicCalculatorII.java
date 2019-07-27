package LeetCode.Stack;

import java.util.Stack;

public class BasicCalculatorII {

    //time: O(n) space: O(n)
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }
            // 最后必须有符号位才可以进行处理 否则无法得到最终结果
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop() * num);
                if (sign == '/') stack.push(stack.pop() / num);
                sign = s.charAt(i);
            }
        }

        for (int i : stack) {
            res += i;
        }
        return res;
    }


    public int calculate2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim().replaceAll(" +", "");
        int res = 0;
        int preVal = 0;
        char sign = '+';
        int i = 0;
        while (i < s.length()) {
            int cuVal = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                cuVal = cuVal * 10 + s.charAt(i) - '0';
                i++;
            }
            if (sign == '+') {
                res += preVal;
                preVal = cuVal;
            } else if (sign == '-') {
                res += preVal;
                preVal = -cuVal;
            } else if (sign == '*') {
                preVal *= cuVal;
            } else if (sign == '/') {
                preVal /= cuVal;
            }
            if (i  < s.length()) {
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }
}
