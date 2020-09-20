package week02;
/**
 * author: Eran-promise
 * question: 翻转二叉树
 * url: https://leetcode-cn.com/problems/invert-binary-tree/
 * action:
 * time complexity：O(n)
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}