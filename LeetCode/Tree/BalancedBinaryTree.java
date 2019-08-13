package LeetCode.Tree;

/**
 * Balanced Binary Tree
 * postorder
 */
public class BalancedBinaryTree {

    public boolean balancedBinaryTree(TreeNode root) {
        if (root == null)   return true;
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null)   return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }
}
