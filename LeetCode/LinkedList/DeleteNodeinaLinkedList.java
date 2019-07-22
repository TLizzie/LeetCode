package LeetCode.LinkedList;

/**
 * Delete Node in a Linked List
 */
public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null)   return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
