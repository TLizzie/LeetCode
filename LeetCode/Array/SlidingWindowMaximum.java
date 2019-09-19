package LeetCode.Array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239 Sliding Window Maximum
 * deque
 * priority queue
 *
 * deque 里面存的是index 从大到小排序
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];
        int[] res = new int[nums.length + 1 - k];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(i);
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[deque.peek()];
            }
        }
        return res;
    }

}
