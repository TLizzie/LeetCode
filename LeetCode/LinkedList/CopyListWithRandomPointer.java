package LeetCode.LinkedList;

import java.util.HashMap;

public class CopyListWithRandomPointer {

    /**
     * time space: O(n)
     * @param head
     * @return
     */

    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(head.val, null, null));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

}

/*
  This code passes all Leetcode test cases as of Jan. 28th 2019
  Runtime: 1 ms, faster than 99.37% of Java online submissions for Copy List with Random Pointer.
  Buckle up and start your imagination...this is about to get tricky...
  Credits: Leetcode user @liaison
*/
//class ConstantSpaceApproach {
//
//    public RandomListNode copyRandomList(RandomListNode head) {
//
//        RandomListNode curr = head;
//        RandomListNode next = null;
//
//    /*
//      First pass.
//      Clone each node and link each original node to it's copy
//      via the original node's net pointer
//    */
//        while (curr != null) {
//
//      /*
//        Stash the next value of the current node so we
//        do not lose it
//      */
//            next = curr.next;
//
//      /*
//        Create the copy node.
//        Point curr (original node) next value to the copy.
//        Point the next value of the copy node to curr (original node) next value.
//        You'll see why we do this later...
//      */
//            RandomListNode copy = new RandomListNode(curr.label);
//            curr.next = copy;
//            copy.next = next;
//
//      /*
//        Advance to next node in the original list
//      */
//            curr = next;
//        }
//
//    /*
//      Second pass.
//      Reset curr to the head of the original list.
//    */
//        curr = head;
//        while (curr != null) {
//
//      /*
//        If there is a random pointer to copy
//      */
//            if (curr.random != null) {
//        /*
//          Assign clone the random mapping
//          "curr.next.random = curr.random.next" means...
//          Jump to the copy node with "curr.next" and set its random value to...
//          "curr.random.next" which is the clone node of curr.random
//          KEY IDEA. We use each original node's next value to map to the clone
//          allowing us to reach the clone list.
//          The hashtable did this for us before. This is how we save space
//        */
//                curr.next.random = curr.random.next;
//            }
//
//      /*
//        Advance to the next node. But why curr.next.next?
//        Well...remember that each clone...points to what? It points
//        to the NEXT node of its original node so that we still have
//        reference to that.
//      */
//            curr = curr.next.next;
//        }
//
//    /*
//      Third pass.
//      Our goal is to restore the original list, and extract the copy list.
//      First reset curr to the head of the original list.
//    */
//        curr = head;
//
//        RandomListNode dummyHead = new RandomListNode(0);
//        RandomListNode cloneListTail = dummyHead;
//        RandomListNode copy = null;
//
//        while (curr != null) {
//
//      /*
//        Stash the next value of the curr original node, remember this...
//        we access that by saying "curr.next.next". We reach to the clone
//        node and hop to that node's next value.
//      */
//            next = curr.next.next;
//
//      /*
//        curr.next is curr's clone. Let's grab it.
//      */
//            copy = curr.next;
//
//      /*
//        Append the copy to the final list tail
//      */
//            cloneListTail.next = copy;
//            cloneListTail = copy;
//
//      /*
//        Restore curr (the original node's) next value
//      */
//            curr.next = next;
//
//      /*
//        Advance curr to the stashed next
//      */
//            curr = next;
//        }
//
//    /*
//      The next node to the dummy head is the head of the
//      deeply cloned list we just made. Return to our caller.
//    */
//        return dummyHead.next;
//    }
//}
