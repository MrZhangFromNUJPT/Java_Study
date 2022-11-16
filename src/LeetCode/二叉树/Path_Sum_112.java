package LeetCode.二叉树;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-19 20:17
 * @Description 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
 * 判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和targetSum。如果存在，返回true；否则，返回false。
 * 叶子节点 是指没有子节点的节点
 */
public class Path_Sum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        else if(root.val==targetSum&&root.left==null&&root.right==null)
            return true;
        else return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}
