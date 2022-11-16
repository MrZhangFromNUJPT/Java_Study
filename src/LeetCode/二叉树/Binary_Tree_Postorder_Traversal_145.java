package LeetCode.二叉树;

import java.util.*;

/**
 * 后序遍历
 */
public class Binary_Tree_Postorder_Traversal_145 {
    //递归
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        postorderTraversalTree(arrayList, root);
        return arrayList;
    }

    public void postorderTraversalTree(List<Integer> list, TreeNode root) {
        if (root == null) return;
        postorderTraversalTree(list, root.left);
        postorderTraversalTree(list, root.right);
        list.add(root.val);
    }
    //迭代 先序遍历（中左右）---换顺序--->（中右左）---反转--->后序遍历（左右中）
    public List<Integer> postorderTraversal_(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root==null) return arrayList;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            arrayList.add(node.val);
            if(node.left!=null)
                stack.push(node.left);
            if(node.right!=null)
                stack.push(node.right);
        }
        Collections.reverse(arrayList);
        return arrayList;
    }
}
