package LeetCode.回溯法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: NJUPT_MR.Z
 * @create: 2022/6/1  19:14
 * @Description: 77
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class Combinations_77 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return result;
    }

    public void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            //注意，深拷贝
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
