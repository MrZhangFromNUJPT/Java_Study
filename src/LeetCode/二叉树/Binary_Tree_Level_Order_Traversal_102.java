package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-06 20:10
 * @Description
 * 层序遍历
 */
public class Binary_Tree_Level_Order_Traversal_102 {

    //队列，经典方法
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return arrayLists;
    }

    //DFS，深度优先遍历，递归
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder_(TreeNode root) {
        checkFun(root, 0);
        return resList;
    }

    public void checkFun(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;
        if (resList.size() < deep) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            resList.add(arrayList);
        }
        resList.get(deep - 1).add(node.val);
        checkFun(node.left, deep);
        checkFun(node.right, deep);
    }


}
