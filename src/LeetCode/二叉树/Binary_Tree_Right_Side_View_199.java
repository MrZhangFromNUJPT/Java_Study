package LeetCode.二叉树;

import Study.Network_Study.InetAddress_Show;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-06 20:40
 * @Description
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 例如：
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 */
public class Binary_Tree_Right_Side_View_199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if(i==size-1)
                    answer.add(node.val);
            }
        }
        return answer;
    }
}
