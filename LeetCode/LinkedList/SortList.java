package LeetCode.LinkedList;

/**
 * 148. Sort List
 * 找中点 断开
 * sortList
 * merge
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode middle = getMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        return merge(sortList(head), sortList(next));

    }

    private ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a != null) {
            cur.next = a;
        } else {
            cur.next = b;
        }
        return dummy.next;
    }
}
