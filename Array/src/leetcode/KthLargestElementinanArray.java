package Array.src.leetcode;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * 7/8/2019
 * 非常重要  快排
 * time: O(nlog k)
 * space: O(1)
 *
 * priority queue
 *
 */

public class KthLargestElementinanArray {
    // quick sort
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k)
                return nums[pos];
            else if (pos + 1 <= k)
                left = pos + 1;
            else if (pos + 1 >= k)
                right = pos - 1;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {

            // 倒叙排 因此加了如下条件 但本质是一样的
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }

            // "=" 的条件很重要  否则超时
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    /**
     * priority queue
     * .offer() ~= add()
     * .poll() Retrieves and removes the head of this queue, or returns null if this queue is empty. 最小值
     *
     * @param nums
     * @param k
     * @return
     */

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.poll();
    }
}
