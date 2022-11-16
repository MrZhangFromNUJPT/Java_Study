package LeetCode.二叉树;

import java.util.LinkedList;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-10 19:35
 * @Description给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class Symmetric_Tree_101 {
    //递归
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return compare(root.left,root.right);
    }

    public boolean compare(TreeNode left,TreeNode right){
        if(left==null&&right!=null) return false;
        else if(left!=null&&right==null) return false;
        else if(left==null&&right==null) return true;
        else if(left.val!=right.val) return false;
        return compare(left.left,right.right)&&compare(left.right,right.left);
    }

    //迭代，用栈
    public boolean isSymmetric_(TreeNode root) {
        if(root==null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left==null&&right==null) continue;
            else if(left==null&&right!=null) return false;
            else if(left!=null&&right==null) return false;
            else if(left.val!=right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
