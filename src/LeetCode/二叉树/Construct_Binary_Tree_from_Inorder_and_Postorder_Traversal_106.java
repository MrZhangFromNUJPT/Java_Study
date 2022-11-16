package LeetCode.二叉树;

import java.util.Arrays;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-21 19:51
 * @Description 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);
        int middle = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(middle);
        int leftLen = 0;
        for (; inorder[leftLen] != middle; leftLen++) ;
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftLen);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftLen);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftLen + 1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftLen, postorder.length - 1);
        node.left = buildTree(leftInorder, leftPostorder);
        node.right = buildTree(rightInorder, rightPostorder);
        return node;
    }
}
