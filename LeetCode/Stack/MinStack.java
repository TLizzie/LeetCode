package LeetCode.Stack;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            if (x <= minStack.peek()) {
               minStack.push(x);
            } else {
            minStack.push(x);
            }
        }
    }

    public void pop() {
        int num = stack.pop();
        stack.pop();
        if (num == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

