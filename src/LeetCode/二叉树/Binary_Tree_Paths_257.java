package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-13 20:01
 * @Description 给你一个二叉树的根节点 root ，按任意顺序，返回所有从根节点到叶子节点的路径。
 * 叶子节点是指没有子节点的节点。
 */
public class Binary_Tree_Paths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val+"");
        while (!stack.isEmpty()){
            String string = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            if(node.left==null&&node.right==null)
                result.add(string);
            if(node.left!=null){
                stack.push(node.left);
                stack.push(string+"->"+node.left.val);
            }
            if(node.right!=null) {
                stack.push(node.right);
                stack.push(string + "->" + node.right.val);
            }
        }
        return result;
    }
    //递归回溯
    public List<String> binaryTreePaths_(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);
        // 叶子结点
        if (root.left == null && root.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
    }
    //深度优先遍历
    public List<String> binaryTreePaths__(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        constructPaths(root,"",paths);
        return paths;
    }
    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if(root!=null){
            StringBuilder stringBuilder = new StringBuilder(path);
            stringBuilder.append(Integer.toString(root.val));
            if(root.left==null&&root.right==null) {
                paths.add(stringBuilder.toString());
            } else {
                stringBuilder.append("->");
                constructPaths(root.left,stringBuilder.toString(),paths);
                constructPaths(root.right,stringBuilder.toString(),paths);
            }
        }
    }
}
