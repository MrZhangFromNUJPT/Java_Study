package LeetCode.二叉树;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-16 21:05
 * @Description
 *
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class Sum_of_Left_Leaves_404 {
    //递归
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        else if(root.left!=null&&root.left.left==null&&root.left.right==null)
            return root.left.val+sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }
    //迭代，略
}
