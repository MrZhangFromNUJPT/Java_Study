package LeetCode.二叉树;

import java.util.*;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-27 18:33
 * @Description 501
 * 给你一个含重复值的二叉搜索树（BST）的根节点root，找出并返回BST中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按任意顺序返回。
 */
public class Find_Mode_in_Binary_Search_Tree_501 {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        preorder(root, hashMap);
        Collection<Integer> values = hashMap.values();
        Integer max = Collections.max(values);
        ArrayList<Integer> arrayList = new ArrayList<>();
        Set<Integer> integers = hashMap.keySet();
        for (Integer i : integers)
            if (hashMap.get(i) == max)
                arrayList.add(i);
        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++)
            answer[i] = arrayList.get(i);
        return answer;
    }

    public void preorder(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            preorder(root.left, map);
            int num = map.getOrDefault(root.val, 0) + 1;
            map.put(root.val, num);
            preorder(root.right, map);
        }
    }
}
