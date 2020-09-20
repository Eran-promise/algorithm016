package week02;

import java.util.ArrayList;
import java.util.List;
/**
 * author: Eran-promise
 * question: N叉树的层序遍历
 * url: https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * action:
 * time complexity：
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        bianli(root, 0, resList);
        return resList;
    }

    private void bianli(Node node, int depth, List<List<Integer>> resList){
        if(node == null) return;
        if(depth + 1 > resList.size()){
            List<Integer> list = new ArrayList<>();
            resList.add(list);
        }
        resList.get(depth).add(node.val);
        for(Node temp: node.children){
            bianli(temp, depth + 1, resList);
        }
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
