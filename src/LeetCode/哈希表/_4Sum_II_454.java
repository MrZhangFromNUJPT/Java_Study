package LeetCode.哈希表;

import java.util.HashMap;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class _4Sum_II_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int sum = 0;
        int n = nums1.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = hashMap.getOrDefault(nums1[i] + nums2[j], 0) + 1;
                hashMap.put(nums1[i] + nums2[j], count);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (hashMap.containsKey(-nums3[i] - nums4[j]))
                    sum += hashMap.get(-nums3[i] - nums4[j]);
        }
        return sum;
    }
}
