package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: NJUPT_MR.Z
 * @create: 2022/5/31  20:44
 * @Description: 538
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同。
 * 请你将其转换为累加树（Greater Sum Tree），使每个节点node的新值等于原树中大于或等于node.val的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class Convert_BST_to_Greater_Tree_538 {
    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBST1(root);
        return root;
    }

    public void convertBST1(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST1(root.right);
        sum += root.val;
        root.val = sum;
        convertBST1(root.left);
    }
}
