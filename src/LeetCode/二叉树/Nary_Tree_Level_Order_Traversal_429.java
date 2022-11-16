package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-06 20:53
 * @Description 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 */


public class Nary_Tree_Level_Order_Traversal_429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        if (root == null) return arrayLists;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                arrayList.add(node.val);
                for (int j = 0; j < node.children.size(); j++)
                    queue.offer(node.children.get(j));
            }
            arrayLists.add(arrayList);
        }
        return arrayLists;
    }
}
