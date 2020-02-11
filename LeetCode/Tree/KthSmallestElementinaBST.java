package LeetCode.Tree;

import java.util.Stack;

public class KthSmallestElementinaBST {

    int count;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        res = 0;
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right);
    }
    
    public int kthSmallest2(TreeNode root, int k) {
         Stack<TreeNode> stack = new Stack<>();
         while (root != null || !stack.isEmpty()) {
             while (root != null) {
                 stack.push(root);
                 root = root.left;
             }
             root = stack.pop();
             if (--count == 0) {
                 break;
             }
             root = root.right;
         }
         return root.val;
    }
}
