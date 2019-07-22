package LeetCode.LinkedList;

/**
 * 141. Linked List Cycle
 * 7/19/2019
 *
 * 思路：设定两个指针 一个fast slow
 * 如果两个指针能碰面 则存在环
 * 也可用hashset
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
