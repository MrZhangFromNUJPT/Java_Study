package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-09 23:25
 * @Description 给定一个 n叉树的根节点root，返回 其节点值的 后序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 */
public class Nary_Tree_Postorder_Traversal_590 {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        postOrder(root, arrayList);
        return arrayList;
    }

    public void postOrder(Node root, List<Integer> list) {
        if (root == null) return;
        int size = root.children.size();
        for (int i = 0; i < size; i++)
            postOrder(root.children.get(i), list);
        list.add(root.val);
    }
}
