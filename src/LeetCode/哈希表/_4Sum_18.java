package LeetCode.哈希表;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class _4Sum_18 {
    //注意取值范围，int类型的取值范围为： -2^31——2^31-1，即-2147483648——2147483647。
    //注意测试用例
    //nums = [0,0,0,-1000000000,-1000000000,-1000000000,-1000000000]
    //target = -1000000000
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if((long)(nums[i]+nums[i+1]+nums[i+2]+nums[i+3])>target) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if((long)(nums[i]+nums[j]+nums[j+1]+nums[j+2])>target) break;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    {
                        if (nums[i] + nums[j] + nums[left] + nums[right] < target)
                            left++;
                        else if (nums[i] + nums[j] + nums[left] + nums[right] > target)
                            right--;
                        else {
                            lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            left++;
                            right--;
                            while (nums[left] == nums[left - 1] && left < right) left++;
                            while (nums[right] == nums[right + 1] && left < right) right--;
                        }
                    }
                }
            }
        }
        return lists;
    }
}
