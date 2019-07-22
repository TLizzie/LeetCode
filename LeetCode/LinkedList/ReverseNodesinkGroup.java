package LeetCode.LinkedList;

/**
 * 25.  Reverse Nodes in k-Group
 * 7/19/2019
 * time: O(n)
 * space : O(n)
 */

public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }

        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count-- != 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}
