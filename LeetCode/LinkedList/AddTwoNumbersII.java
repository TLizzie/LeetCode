package LeetCode.LinkedList;

import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        ListNode p = reverse(l1);
        ListNode q = reverse(l2);
        int carry = 0;

        while (p != null || q != null || carry == 1) {
            int sum = 0;
            if (p != null) {
                sum += p.val;
                p = p.next;
            }

            if (q != null) {
                sum += q.val;
                q = q.next;
            }
            sum += carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
        }

        return reverse(dummy.next);

    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = null;
        ListNode pre = null;
        ListNode curr = head;

        while(curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    //follow up using stack()
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode cur = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            cur.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = cur;
            sum /= 10;
            cur = head;
        }

        return cur.val == 0 ? cur.next : cur;
    }
}
