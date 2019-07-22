package LeetCode.LinkedList;

/**
 * 24. Swap Nodes in Pairs
 * 头结点安排
 * 按顺序输出
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            ListNode node = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = node;
            l1 = l2;
            l2 = l1.next;
        }
        return dummy.next;
    }

}
