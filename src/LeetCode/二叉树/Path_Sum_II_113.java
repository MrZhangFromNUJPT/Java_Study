package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-19 20:26
 * @Description 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class Path_Sum_II_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        if(root==null)
            return arrayLists;
        List<Integer> arrayList = new ArrayList<>();
        isPathSum(root,targetSum,arrayLists,arrayList);
        return arrayLists;
    }

    public void isPathSum(TreeNode root, int targetSum, List<List<Integer>> answer,List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.val == targetSum && root.left == null && root.right == null)
            answer.add(list);
        else{
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.addAll(list);
            isPathSum(root.left,targetSum-root.val,answer,list);
            isPathSum(root.right,targetSum-root.val,answer,list1);
        }
    }
}
