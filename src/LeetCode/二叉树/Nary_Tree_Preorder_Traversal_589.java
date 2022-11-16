package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-09 22:42
 * @Description
 * 给定一个 n叉树的根节点 root，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * // Definition for a Node.
 * class Node {
 *     public int val;
 *     public List<Node> children;
 *
 *     public Node() {}
 *
 *     public Node(int _val) {
 *         val = _val;
 *     }
 *
 *     public Node(int _val, List<Node> _children) {
 *         val = _val;
 *         children = _children;
 *     }
 * };
 * */
public class Nary_Tree_Preorder_Traversal_589 {
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        preOrder(root, arrayList);
        return arrayList;
    }

    public void preOrder(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        int size = root.children.size();
        for (int i = 0; i < size; i++)
            preOrder(root.children.get(i), list);
    }
}
