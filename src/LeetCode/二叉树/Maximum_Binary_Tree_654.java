package LeetCode.二叉树;

import java.util.Arrays;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-21 20:21
 * @Description 654
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 */
public class Maximum_Binary_Tree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
        return node;
    }
}
