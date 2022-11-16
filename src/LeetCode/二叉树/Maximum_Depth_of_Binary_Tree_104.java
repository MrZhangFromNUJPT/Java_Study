package LeetCode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-07 22:26
 * @Description 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Maximum_Depth_of_Binary_Tree_104 {
    //非递归，层次遍历
    public int maxDepth_(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
        }
        return depth;
    }
    //递归
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
