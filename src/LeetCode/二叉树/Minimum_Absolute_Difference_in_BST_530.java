package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-27 18:24
 * @Description
 */
public class Minimum_Absolute_Difference_in_BST_530 {
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preorder(root, list);
        int dif = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++)
            dif = Math.min(dif, list.get(i) - list.get(i - 1));
        return dif;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            preorder(root.left, list);
            list.add(root.val);
            preorder(root.right, list);
        }
    }
}
