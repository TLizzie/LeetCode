package LeetCode.Tree;

public class SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int num) {
        if (root == null)
            return 0;
        if (root.right == null && root.left == null) {
            return num * 10 + root.val;
        }
        return helper(root.left, num * 10 + root.val) + helper(root.right, num * 10 + root.val);
    }
}
