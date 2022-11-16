package LeetCode.二叉树;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-27 18:03
 * @Description 98
 * 给你一个二叉树的根节点root，判断其是否是一个有效的二叉搜索树。
 * 有效二叉搜索树定义如下：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Validate_Binary_Search_Tree_98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (leftSon(root.left, root.val) == false) return false;
        if (rightSon(root.right, root.val) == false) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean leftSon(TreeNode root, int max) {
        if (root == null) return true;
        if (root.val >= max) return false;
        if (leftSon(root.left, max) == false) return false;
        else return leftSon(root.right, max);
    }

    public boolean rightSon(TreeNode root, int min) {
        if (root == null) return true;
        if (root.val <= min) return false;
        if (rightSon(root.left, min) == false) return false;
        else return rightSon(root.right, min);
    }

    //good solution
    public boolean isValidBST_(TreeNode root) {
        return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    boolean validBST(long lower, long upper, TreeNode root) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return validBST(lower, root.val, root.left) && validBST(root.val, upper, root.right);
    }
}
