package LeetCode.数组.移除元素;

import java.util.Arrays;
/**
给你一个按非递减顺序排序的整数数组nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
*/


public class Squares_of_a_Sorted_Array_977 {
    //暴力
    public int[] sortedSquares_1(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i] * nums[i];
        Arrays.sort(nums);
        return nums;
    }

    //双指针
    public int[] sortedSquares_2(int[] nums) {
        int[] ans = new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int pos = ans.length-1;
        while(i<=j){
            if(nums[i]*nums[i]>nums[j]*nums[j]) {
                ans[pos] = nums[i] * nums[i];
                i++;
            }
            else{
                ans[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}
