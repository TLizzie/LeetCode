package LeetCode.LinkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null || q != null) {
            if (p != null) {
                sum += p.val;
                p = p.next;
            }
            if (q != null) {
                sum += q.val;
                q = q.next;
            }

            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }

        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
