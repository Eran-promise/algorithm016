package week02;

import java.util.ArrayList;
import java.util.List;
/**
 * author: Eran-promise
 * question: 二叉树遍历
 * url: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * action:
 * time complexity：
 */
public class BinaryTreeTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        bianli(root, resList);
        return resList;
    }

    /**
     * 二叉树中序遍历
     * @param node
     * @param list
     */
    private void bianli(TreeNode node, List<Integer> list){
        if(node == null) return;
        bianli(node.left, list);
        list.add(node.val);
        bianli(node.right, list);
    }

    /**
     * 二叉树前序遍历
     * @param node
     * @param list
     */
    private void bianli2(TreeNode node, List<Integer> list){
        if(node == null) return;
        list.add(node.val);
        bianli(node.left, list);
        bianli(node.right, list);
    }

    /**
     * 二叉树后序遍历
     * @param node
     * @param list
     */
    private void bianli3(TreeNode node, List<Integer> list){
        if(node == null) return;
        bianli(node.left, list);
        bianli(node.right, list);
        list.add(node.val);
    }
}
