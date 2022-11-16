package LeetCode.二叉树;

import java.util.Arrays;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-21 20:09
 * @Description 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        int middle = preorder[0];
        TreeNode node = new TreeNode(middle);
        int leftLen = 0;
        for (; inorder[leftLen] != middle; leftLen++) ;
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftLen + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftLen);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftLen + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftLen + 1, inorder.length);
        node.left = buildTree(leftPreorder, leftInorder);
        node.right = buildTree(rightPreorder, rightInorder);
        return node;
    }
}
