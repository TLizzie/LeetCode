package LeetCode.LinkedList;

/**
 * 149. Insertion Sort List
 * 7/20/2019
 * time : O(n ^ 2) 插入排序
 * space:  O(1)
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode temp = null, prev = null;

        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {
                temp = cur.next;
                cur.next = temp.next;
                prev = dummy;
                while (prev.next.val <= temp.val) {
                    prev = prev.next;
                }
                temp.next = prev.next;
                prev.next = temp;
            }
        }
        return dummy.next;
    }
}
