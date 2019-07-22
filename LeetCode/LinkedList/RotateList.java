package LeetCode.LinkedList;

import javax.swing.*;

/**
 * 61. Rotate List
 * 收尾相连
 * 然后断开 释放空间
 *
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int len = 1;
        ListNode index = head;
        while (index != null && index.next != null) {
            index = index.next;
            len++;
        }
        index.next = head;
        for (int i = 1; i < len - k % len; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }
}
