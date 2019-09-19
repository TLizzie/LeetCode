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

    public String decodeString2(String s) {
        if (s == null || s.length() == 0)
            return s;
        Stack<Integer> cntStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + ch - '0';
            } else if (ch == '[') {
                cntStack.push(count);
                count = 0;
                strStack.push(cur);
                cur = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder temp = cur;
                cur = strStack.pop();
                for (int k = cntStack.pop(); k > 0; k--) {
                    cur.append(temp);
                }
            } else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }
}
