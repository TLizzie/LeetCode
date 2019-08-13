package LeetCode.Tree;

/**
 * 124. Binary Tree Maximum Path Sum
 *  a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 *  直接不用考虑preorder bst
 *
 */
public class BinaryTreeMaximumPathSum {

    int res;

    public int maxPathSum(TreeNode root) {
        if (root == null)   return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null)   return 0;

        // 返回的是左子树 和 右子树的总和
        // math.max 是为了剔除负数的影响
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        //res是路径
        //return 是当前最大sum的路径
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
