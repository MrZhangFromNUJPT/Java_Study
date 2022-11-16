package LeetCode.二叉树;

import java.util.*;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-06 20:34
 * @Description
 * 给你二叉树的根节点 root ，返回其节点值自底向上的层序遍历 。(即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历)
 */
public class Binary_Tree_Level_Order_Traversal_II_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        if (root == null) return arrayLists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                arrayList.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            arrayLists.add(arrayList);
        }
        Collections.reverse(arrayLists);
        return arrayLists;
    }
}
