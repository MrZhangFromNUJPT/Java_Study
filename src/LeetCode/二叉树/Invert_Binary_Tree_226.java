package LeetCode.二叉树;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-09 22:36
 * @Description
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class Invert_Binary_Tree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        return root;
    }
}
