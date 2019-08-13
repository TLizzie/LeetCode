package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * time: O(n);
 * space: O(n);
 *
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> binaryTreeTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)   return res;
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null)   return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    public List<Integer> binaryTreeTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            res.add(root.val);
        }
        return res;
    }
}
