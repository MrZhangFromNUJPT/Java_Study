package LeetCode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-07 19:56
 * @Description 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 */
public class Populating_Next_Right_Pointers_in_Each_Node_116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int nodeNum = queue.size();
            Node foreNode;
            Node behindNode;
            for (int i = 0; i < nodeNum; i++) {
                foreNode = queue.poll();
                if (i != nodeNum - 1) {
                    behindNode = queue.peek();
                    foreNode.next = behindNode;
                }
                if (foreNode.left != null)
                    queue.offer(foreNode.left);
                if (foreNode.right != null)
                    queue.offer(foreNode.right);
            }
        }
        return root;
    }
}
