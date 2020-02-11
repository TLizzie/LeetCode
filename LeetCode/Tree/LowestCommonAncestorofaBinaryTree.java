package LeetCode.Tree;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * postorder???
 *
 * focus on the current node working on, look up its left & right subtree value, make sure if its the one we want.
 * get the result from bottom to top
 *
 * time: O(n)
 * space: O(n) (O(h))
 *
 */
public class LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
