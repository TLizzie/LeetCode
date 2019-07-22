package LeetCode.LinkedList;

/**
 * 160. Intersection of Two Linked Lists
 * 7/20/2019
 * time : O(n)
 * space: O(1)
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = findLength(headA);
        int lenB = findLength(headB);

        if (lenA != lenB) {
            if (lenA > lenB) {
                while (lenA != lenB) {
                    headA = headA.next;
                    lenA--;
                }
            } else {
                while (lenA != lenB) {
                    headB = headB.next;
                    lenB--;
                }
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int findLength(ListNode head) {
        int len = 1;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * time: O(m + n)
     * space: O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}
