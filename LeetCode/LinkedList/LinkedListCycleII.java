package LeetCode.LinkedList;

/**
 * 142. Linked List Cycle II
 * 7/19/2019
 * 慢的 a + b + n1  (slow 走的圈数)
 * fast: a + b + c + b == 2 * (a + b) + n2 (fast走的圈数 并不影响)
 *
 * a == c 再设置一个指针从头走
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
