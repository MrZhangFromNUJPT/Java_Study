package LeetCode.二叉树;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-07 19:46
 * @Description 给定一棵二叉树的根节点root，请找出该二叉树中每一层的最大值。
 */
public class Find_Largest_Value_in_Each_Tree_Row_515 {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) return arrayList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(max<node.val)
                    max = node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            arrayList.add(max);
        }
        return arrayList;
    }
}
