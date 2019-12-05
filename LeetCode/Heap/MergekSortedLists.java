package LeetCode.Heap;


import LeetCode.LinkedList.ListNode;

import java.util.PriorityQueue;

//time: O(nlogn)
//space: O(n)

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }

        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (!queue.isEmpty()) {
            pre.next = queue.poll();
            pre = pre.next;

            if (pre.next != null) {
                queue.offer(pre.next);
            }
        }
        return dummy.next;
    }
}
