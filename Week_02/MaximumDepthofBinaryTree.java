package week02;
/**
 * author: Eran-promise
 * question: 二叉树的最大深度
 * url: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * action:
 * time complexity：O(n)
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
