package LeetCode.Heap;


import java.util.PriorityQueue;

/**
 * 703
 * time: O(n)
 * space: O(n)
 */
public class KthLargestElementinaStream {
    
    PriorityQueue<Integer> heap;
    int k;
    
    public KthLargestElementinaStream(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        
//        maintain a minHeap to store the kth largest in the array
        
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
