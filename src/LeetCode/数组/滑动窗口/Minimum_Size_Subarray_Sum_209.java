package LeetCode.数组.滑动窗口;
/**
给定一个含有n个正整数的数组和一个正整数 target 。
找出该数组中满足其和≥target的长度最小的连续子数组[numsl,numsl+1, ...,numsr-1,numsr]，并返回其长度。如果不存在符合条件的子数组，返回0。
*/
public class Minimum_Size_Subarray_Sum_209 {
    //暴力求解，双层循环
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int l = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                l++;
                if (sum >= target) {
                    length = length > l ? l : length;
                    break;
                }
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }

    //滑动窗口
    public int minSubArrayLen_2(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        int i = 0;
        int subLength;
        int sum = 0;
        //滑动窗口核心代码
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            //对条件进行判断，是否移动左边
            while (sum >= target) {
                subLength = j - i + 1;
                length = Math.min(subLength, length);
                sum -= nums[i++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
