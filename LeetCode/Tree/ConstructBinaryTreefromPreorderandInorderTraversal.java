package LeetCode.Tree;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *    3
     / \
     9  20
     /  \
    15   7

 inorder : 15 9 7 3 20
 preorder : 3 9 15 7 20

 time : O(n)
 space : O(n)

 */

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;

        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                inIndex = i;
            }
        }

        root.left = helper(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        root.right = helper(preorder, inorder, preStart + 1 + inIndex - inStart, inIndex + 1, inEnd);
        return root;
    }
}
