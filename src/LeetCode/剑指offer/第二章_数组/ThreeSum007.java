package LeetCode.剑指offer.第二章_数组;

import java.util.*;

/**
 * @author ZhiPengZhang
 * @date 2022/11/7 20:39
 * @description 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 **/
public class ThreeSum007 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i <= nums.length - 3) {
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    int temp = nums[left];
                    while (left < right && nums[left] == temp) {
                        left++;
                    }
                    right--;
                }
            }
            int temp = nums[i];
            while (i < nums.length && nums[i] == temp) {
                i++;
            }
        }
        return new ArrayList<>(result);
    }
}
