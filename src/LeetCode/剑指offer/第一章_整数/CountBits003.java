package LeetCode.剑指offer.第一章_整数;

/**
 * @author ZhiPengZhang
 * @date 2022/11/3 21:10
 * @description
 **/
public class CountBits003 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + i & 1;
        }
        return result;
    }
}
