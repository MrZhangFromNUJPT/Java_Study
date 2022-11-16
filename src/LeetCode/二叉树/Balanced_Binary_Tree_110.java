package LeetCode.二叉树;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-12 20:15
 * @Description
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Balanced_Binary_Tree_110 {
    //递归
    public boolean isBalanced(TreeNode root) {
        if(root==null) {
            return true;
        } else if(Math.abs(getDepth(root.left)-getDepth(root.right))>1) {
            return false;
        } else {
            return isBalanced(root.left)&&isBalanced(root.right);
        }
    }
    public int getDepth(TreeNode root) {
        if(root==null) {
            return 0;
        } else {
            return 1+Math.max(getDepth(root.left),getDepth(root.right));
        }
    }
}
