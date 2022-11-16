package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-06 20:47
 * @Description
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10^-5 以内的答案可以被接受。
 */
public class Average_of_Levels_in_Binary_Tree_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if(i==size-1) {
                    answer.add(sum/size);
                }
            }
        }
        return answer;
    }
}
