package LeetCode.Design;

import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 *
 * small heap and large heap
 * roots of the heaps are the candidates of median
 * keep balanced: 0 <= |small.size()| - |large.size()| <= 1
 * time complexity: O(logn)
 */
public class FindMedianfromDataStream {
    /** initialize your data structure here. */

    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;

    public FindMedianfromDataStream() {
//        larger half and lower half
        this.large = new PriorityQueue<>();
        this.small = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        large.offer(num);
        small.offer(large.poll());
        if (large.size() < small.size()) {
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        if (large.size() == small.size()) {
            return (large.peek() + small.peek()) / 2.0;
        }
        return large.peek();
    }
}
