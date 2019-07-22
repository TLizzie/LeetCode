package LeetCode.LinkedList;

/**
 * 82 .Remove Duplicates from Sorted List II
 * 7/19/2019
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val == pre.next.next.val) {
                int sameNum = pre.next.val;
                while (pre.next != null && pre.next.val == sameNum) {
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
