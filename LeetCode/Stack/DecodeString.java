package LeetCode.Stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;
        Stack<Integer> cntStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = "";
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int num = 0;
                while (Character.isDigit(s.charAt(index))) {
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                cntStack.push(num);
            } else if (s.charAt(index) == '[') {
                    resStack.push(res);
                    res = "";
                    index++;
            } else if (s.charAt(index) == ']') {
                    int time = cntStack.pop();
                    StringBuilder temp = new StringBuilder(resStack.pop());
                    for (int i = 0; i < time; i++) {
                        temp.append(res);
                    }
                    res = temp.toString();
                    index++;
            } else {
                    res += s.charAt(index++);
                }
            }
        return res;
    }
}
