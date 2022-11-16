package LeetCode.二叉树;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-12 19:59
 * @Description 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~2h个节点。
 */
public class Count_Complete_Tree_Nodes_222 {
    //遍历
    public int countNodes_(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes_(root.left) + countNodes_(root.right);
    }

    //利用完全二叉树的性质
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth)
            return (int) Math.pow(2, leftDepth) + countNodes(root.right);
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}
