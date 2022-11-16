package LeetCode.二叉树;

/**
 * @author: NJUPT_MR.Z
 * @create: 2022/5/30  21:10
 * @Description: 701
 * 给定二叉搜索树（BST）的根节点root和要插入树中的值value，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 * 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。你可以返回任意有效的结果 。
 */
public class Insert_into_a_Binary_Search_Tree_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root==null) {
            return node;
        }
        TreeNode treeNode = root;
        while(true){
            if(treeNode.val<val&&treeNode.right==null){
                treeNode.right=node;
                break;
            } else if (treeNode.val < val) {
                treeNode = treeNode.right;
            } else if (treeNode.val > val && treeNode.left == null) {
                treeNode.left = node;
                break;
            } else if (treeNode.val > val) {
                treeNode = treeNode.left;
            }
        }
        return root;
    }
}
