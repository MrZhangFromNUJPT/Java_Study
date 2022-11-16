package LeetCode.哈希表;
/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum_15 {
    //可用哈希法或双指针法，关键是“去重”，下面是双指针法
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return lists;
            if (i > 0 && nums[i] == nums[i - 1]) continue;  //去重
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (right > left && nums[left] == nums[left - 1]) left++;    //去重
                    while (right > left && nums[right] == nums[right + 1]) right--;  //去重
                }
            }
        }
        return lists;
    }
}
