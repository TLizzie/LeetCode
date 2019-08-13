package LeetCode.Tree;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 * Input: [1,2,3,4,5]
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 *
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 *
 * 把左子树继续颠倒，颠倒完后，原来的那个左孩子的左右孩子指针分别指向原来的根节点以及原来的右兄弟节点即可。
 *
 */
public class BinaryTreeUpsideDown {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if (root == null)   return null;
        TreeNode parent = root, left = root.left, right = root.right;
        if (left != null) {
            TreeNode res = UpsideDownBinaryTree(left);
            left.left = right;
            left.right = parent;
            return res;
        }
        return root;
    }

    public TreeNode UpsideDownBinaryTree2(TreeNode root) {
//        if (root == null)   return null;
        TreeNode node = root, parent = null, right = null;
        while (node != null) {
            TreeNode left = node.left;
            node.left = right;
            right = node.right;
            node.right = parent;
            parent = node;
            node = left;
        }
        return parent;
    }

    public TreeNode UpsideDownBinaryTree3(TreeNode root) {
        if (root == null || root.right == null || root.left == null)
            return root;
        TreeNode newRoot = UpsideDownBinaryTree3(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;
        return newRoot;
    }
}
