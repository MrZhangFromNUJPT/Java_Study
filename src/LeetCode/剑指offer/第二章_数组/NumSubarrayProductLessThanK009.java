package LeetCode.剑指offer.第二章_数组;

/**
 * @author ZhiPengZhang
 * @date 2022/11/8 19:52
 * @description 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 **/
@SuppressWarnings("all")
public class NumSubarrayProductLessThanK009 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int i = 0;
        int j = 0;
        int sub = 1;
        while (j < nums.length) {
            sub *= nums[j];
            while (i <= j && sub >= k) {
                sub /= nums[i++];
            }
            result += j - i + 1;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        numSubarrayProductLessThanK(a, 100);
        ;
    }
}
