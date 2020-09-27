package week03;

import java.util.HashMap;
import java.util.Map;
/**
 * author: Eran-promise
 * question: 从前序与中序遍历序列构造二叉树
 * url: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * action:
 * time complexity：O(n)
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    Map<Integer, Integer> box = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        for(int i = 0; i < inorder.length; i++){
            box.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length , inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int left1, int right1, int[] inorder, int left2, int right2){
        if(left1 == right1) return null;
        TreeNode node = new TreeNode(preorder[left1]);
        int index = box.get(node.val);
        int length = index - left2;
        node.left =  buildTree(preorder, left1 + 1, left1 + length + 1, inorder, left2, left2 + length);
        node.right = buildTree(preorder, left1 + length + 1, right1, inorder, left2 + length + 1, right2);
        return node;
    }
}
