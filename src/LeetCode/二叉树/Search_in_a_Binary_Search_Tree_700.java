package LeetCode.二叉树;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-23 20:32
 * @Description 700
 * 给定二叉搜索树（BST）的根节点root和一个整数值val。
 * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
 */
public class Search_in_a_Binary_Search_Tree_700 {
    //递归
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        else if (root.val == val) return root;
        else if (root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }

    //迭代
    public TreeNode searchBST_(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode node = root;
        while (node != null) {
            if (node.val == val)
                return node;
            else if (node.val < val)
                node = node.right;
            else
                node = node.left;
        }
        return null;
    }
}
