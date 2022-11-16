package LeetCode.剑指offer.第二章_数组;

/**
 * @author ZhiPengZhang
 * @date 2022/11/8 19:39
 * @description 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 **/
@SuppressWarnings("all")
public class MinSubArrayLen008 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum - nums[i] >= target) {
                sum -= nums[i++];
            }
            if (sum >= target) {
                int len = j - i;
                minLen = Math.min(minLen, len);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
