package LeetCode.LinkedList;

/**
 * 206	Reverse Linked List
 * 7/18/2019
 * 代码需要背下来
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}
