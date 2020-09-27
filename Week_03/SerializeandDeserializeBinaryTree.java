package week03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * author: Eran-promise
 * question: 二叉树的序列化与反序列化
 * url: https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * action: https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/297er-cha-shu-de-xu-lie-hua-he-fan-xu-lie-hua-by-w/
 * time complexity：O(n)
 */
public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(arr));
        return deserialize(list);
    }

    private TreeNode deserialize(List<String> list){
        if(list.size() == 0 || "null".equals(list.get(0))){
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }
}
