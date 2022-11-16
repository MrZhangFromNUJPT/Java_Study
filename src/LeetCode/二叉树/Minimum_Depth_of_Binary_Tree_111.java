package LeetCode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-07 22:33
 * @Description 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Minimum_Depth_of_Binary_Tree_111 {
    //递归
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if(root.left==null||root.right==null)
            return 1+((root.left==null)?minDepth(root.right):minDepth(root.left));
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }

    //非递归，层次遍历
    public int minDepth_(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left==null&&node.right==null)
                    return depth;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
        }
        return depth;
    }
}
