package LeetCode.二叉树;

import java.util.List;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-09 22:43
 * @Description
 * N叉树
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}