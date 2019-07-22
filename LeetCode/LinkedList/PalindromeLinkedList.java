package LeetCode.LinkedList;

/**
 * 234. Palindrome Linked List
 * 7/20/2019
 * 思路：
 * 找中点 翻转 判断
 * 找中点的时候 fast = head.next 否则会报错
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);

        ListNode p = head;
        ListNode q = middle.next;
        while (p != null && q != null) {
            if (p.val == q.val) {
                p = p.next;
                q = q.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
