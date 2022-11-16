package LeetCode.二叉树;

import java.util.Arrays;

/**
 * @author: NJUPT_MR.Z
 * @create: 2022/5/31  20:37
 * @Description: 108
 * 给你一个整数数组 nums ，其中元素已经按升序排列，请你将其转换为一棵高度平衡二叉搜索树。
 * 高度平衡二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过1」的二叉树。
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(nums[nums.length / 2]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return node;
    }
}
