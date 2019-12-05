package LeetCode.Heap;

/**
 * time: O(nlogn)
 * space: O(n)
 */

import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]));
        for (int[] p : points) {
            pq.offer(p);
//            poll out the larger distance points
            if (pq.size() > K) {
                pq.poll();
            }
        }
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }
}
