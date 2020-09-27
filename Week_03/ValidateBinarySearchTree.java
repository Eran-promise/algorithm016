package week03;
/**
 * author: Eran-promise
 * question: 验证二叉搜索树
 * url: https://leetcode-cn.com/problems/validate-binary-search-tree/
 * action:
 * time complexity：O(n)
 */
public class ValidateBinarySearchTree {
    long min = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(root.val <= min) return false;
        min = root.val;
        return isValidBST(root.right);
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

