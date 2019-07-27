package LeetCode.Stack;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * 7/25/2019
 * stack1 存的是输入的queue
 * stack2 存的是处理过后的queue
 */
public class ImplementQueueusingStacks {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public ImplementQueueusingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}

class ImplementQueueusingStacksII {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    private int front;

    public ImplementQueueusingStacksII() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

    }

    public int pop() {
        int res = stack1.pop();
        if (stack1.isEmpty()) {
            front = stack1.pop();
        }
        return res;
    }

    public int peek() {
        return front;
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
