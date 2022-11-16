package LeetCode.哈希表;
/**
给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。
 */

import java.util.HashMap;

//暴力
class Two_Sum_1 {
    public int[] Two_Sum_Solution_1(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
        return answer;
    }
    //哈希
    public int[] tTwo_Sum_Solution_2(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;++i){
            if(hashMap.containsKey(target-nums[i])) {
                answer[0] = hashMap.get(target - nums[i]);
                answer[1]=i;
                break;
            }
            else
                hashMap.put(nums[i],i);
        }
        return answer;
    }
}


