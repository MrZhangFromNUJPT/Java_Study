package LeetCode.二叉树;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 先序遍历
 */
public class Binary_Tree_Preorder_Traversal_144 {
    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        preorderTraversalTree(arrayList, root);
        return arrayList;
    }

    public void preorderTraversalTree(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        preorderTraversalTree(list, root.left);
        preorderTraversalTree(list, root.right);
    }

    //迭代
    public List<Integer> preorderTraversal_(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return result;
    }
}
