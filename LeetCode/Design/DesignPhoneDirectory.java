package LeetCode.Design;

/**
 *
 * set 里面存不可用的
 * queue 里面存可用的
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DesignPhoneDirectory {

    HashSet<Integer> used;
    Queue<Integer> queue;
    int maxNumbers;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        this.queue = new LinkedList<>();
        this.used = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Integer res = queue.poll();
        if (res == null) {
            return -1;
        }
        used.add(res);
        return res;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number < 0 || number > maxNumbers) {
            return false;
        }
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (used.remove(number)) {
            queue.offer(number);
        }
    }


}
