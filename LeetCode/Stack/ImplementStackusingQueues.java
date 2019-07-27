package LeetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
    /**
     * stack :  1 -> 2 -> 3 -> 4
     * queue :  4 -> 3 -> 2 -> 1
     * queue 前后开口 先进先出
     */

    Queue<Integer> queue;
    public ImplementStackusingQueues() {

        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
