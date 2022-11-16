package LeetCode.剑指offer.第一章_整数;

/**
 * @author ZhiPengZhang
 * @date 2022/11/5 20:28
 * @description
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 **/
public class SingleNumber004 {
    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSum[i] += (num >> (31 - i)) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += bitSum[i] % 3 << (31 - i);
        }
        return result;
    }
}
