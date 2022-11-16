package LeetCode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-10 19:58
 * @Description
 * 给你两棵二叉树 root 和 subRoot 。
 * 检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 */
public class Subtree_of_Another_Tree_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(isSameTree(node,subRoot)) return true;
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        else if(p!=null&&q==null) return false;
        else if(p==null&&q!=null) return false;
        else if(p.val!=q.val) return false;
        else return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
