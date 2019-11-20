package LeetCode.Tree;

/**
 * leetcode 572. Subtree of Another Tree
 * time : O(m * n) worst case
 * space: O(n) # of nodes in s
 */

public class isSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)  return false;
        if (helper(s, t))   return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}
