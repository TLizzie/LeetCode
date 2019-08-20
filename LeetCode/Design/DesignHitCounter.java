package LeetCode.Design;

/**
 * queue
 * array
 *
 */

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public DesignHitCounter() {
        this.queue = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        //O(1)
        queue.offer(timestamp);

    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            //O(1)
            queue.poll();
        }
        return queue.size();
    }




}
