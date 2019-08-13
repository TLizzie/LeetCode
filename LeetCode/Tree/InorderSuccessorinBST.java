package LeetCode.Tree;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 * time, space : O(n)
 */
public class InorderSuccessorinBST {

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)   return null;
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }

    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode temp = successor(root.left, p);
            return temp == null ? null : temp;
        }
    }

}
