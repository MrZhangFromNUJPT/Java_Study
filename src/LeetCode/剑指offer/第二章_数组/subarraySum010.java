package LeetCode.剑指offer.第二章_数组;

import java.util.HashMap;

/**
 * @author ZhiPengZhang
 * @date 2022/11/11 20:20
 * @description
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 **/
@SuppressWarnings("all")
public class subarraySum010 {
    //初始写法,前缀和,时间复杂度O(n^2),空间复杂度O(n)
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        //第一次遍历求出累加数组
        int[] initial = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            initial[i] = sum;
        }
        //两个for循环求答案
        for (int i = -1; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = i == -1 ? 0 : initial[i];
                if (initial[j] - temp == k) {
                    result++;
                }
            }
        }
        return result;
    }

    //前缀和小改进，时间复杂度O(n^2),空间复杂度O(n)
    public int subarraySum2(int[] nums, int k) {
        int result = 0;
        //遍历求出累加数组,并在此过程中同时求答案
        int[] initial = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            initial[i] = sum;
            if (initial[i] == k) {
                result++;
            }
            for (int j = 0; j < i; j++) {
                if (initial[i] - initial[j] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    //最佳写法,用哈希表改进,时间复杂度O(n),空间复杂度O(n)
    public int subarraySum3(int[] nums, int k) {
        //键记录前缀和，值记录这个前缀和出现的次数
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int result = 0;
        int sum = 0;
        //初始的一个键值对
        hashMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //加上sum-k这个前缀和已经出现的次数
            result += hashMap.getOrDefault(sum - k, 0);
            //将这个前缀和加入到哈希表中
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
