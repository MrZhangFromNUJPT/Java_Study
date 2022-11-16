package LeetCode.回溯法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: NJUPT_MR.Z
 * @create: 2022/6/2  20:56
 * @Description: 216
 * 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class Combination_Sum_III_216 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1, 0);
        return result;
    }

    public void backTracking(int k, int n, int startIndex, int sum) {
        //剪枝
        if (sum > n) {
            return;
        }
        if (path.size() == k && sum == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        //9 - (k - path.size()) + 1 剪枝
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(k, n, i + 1, sum);
            //回溯
            path.removeLast();
            sum -= i;
        }
    }
}
