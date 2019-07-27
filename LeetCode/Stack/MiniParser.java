package LeetCode.Stack;

import java.util.List;
import java.util.Stack;



  public interface NestedInteger {

      NestedInteger();

      NestedInteger(int value);

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
       boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
       Integer getInteger();

      // Set this NestedInteger to hold a single integer.
       void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
       void add(NestedInteger ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
       List<NestedInteger> getList();
  }


public class MiniParser implements NestedInteger {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.valueOf(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger res = new NestedInteger();
        stack.push(res);
        int start = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                NestedInteger nestedInteger = new NestedInteger();
                stack.peek().add(nestedInteger);
                stack.push(nestedInteger);
                start = i + 1;
            } else if (c == ',' || c == ']') {
                if (i > start) {
                    Integer val = Integer.valueOf(s.substring(start, i));
                    stack.peek().add(new NestedInteger(val));
                }
                start = i + 1;
                if (c == ']') {
                    stack.pop();
                }
            }
        }
        return res;
    }

}
