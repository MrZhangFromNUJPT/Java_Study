package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 中序遍历
 */
public class Binary_Tree_Inorder_Traversal_94 {
    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        inorderTraversalTree(arrayList, root);
        return arrayList;
    }
    public void inorderTraversalTree(List<Integer> list , TreeNode root) {
        if(root==null) return;
        inorderTraversalTree(list,root.left);
        list.add(root.val);
        inorderTraversalTree(list,root.right);
    }
    //迭代
    public List<Integer> inorderTraversal_(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root==null) return arrayList;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                arrayList.add(cur.val);
                cur = cur.right;
            }
        }
        return arrayList;
    }
}
