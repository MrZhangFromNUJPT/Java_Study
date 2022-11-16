package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-16 21:11
 * @Description 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 */
public class Find_Bottom_Left_Tree_Value_513 {
    //层序遍历
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                arrayList.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            if(queue.isEmpty())
                return arrayList.get(0);
        }
        return -1;
    }
}
