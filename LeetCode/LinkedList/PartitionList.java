package LeetCode.LinkedList;

/**
 * 86. Partition List
 * 7/18/2019
 * 基本操作
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode smallHead = new ListNode(0),
                 bigHead = new ListNode(0),
                 small = smallHead,
                 big = bigHead;

        while (head != null) {
            ListNode temp = new ListNode(head.val);
                if (head.val < x) {
                    small.next = temp;
                    small = small.next;
                } else {
                    big.next = temp;
                    big = big.next;
                }
                head = head.next;
            }
        small.next = bigHead.next;
        return smallHead.next;
    }
}
