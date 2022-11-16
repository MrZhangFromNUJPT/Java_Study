package LeetCode.数组.移除元素;

import java.util.Arrays;

/**
给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
*/
public class Remove_Element_27 {
    //暴力
    public int removeElement_1(int[] nums, int val) {
        int i=0;
        int size = nums.length;
        for(i=0;i<nums.length;i++){
            if(val == nums[i]) {
                for (int j=i+1;j<size;j++)
                    nums[j-1]=nums[j];
                i--;
                size--;
            }
        }
        return size;
    }
    //双指针1，同向
    public int removeElement_2(int[] nums, int val) {
        int slowIndex = 0;
        for(int fastIndex = 0;fastIndex< nums.length;fastIndex++){
            if(val!=nums[fastIndex]){
                nums[slowIndex++]=nums[fastIndex];
            }
        }
        return slowIndex;
    }
    //双指针2,异向
    public int removeElement_3(int[] nums, int val) {
        int headIndex = 0;
        int tailIndex = nums.length-1;
        while(headIndex<=tailIndex){
            while(headIndex<=tailIndex&&nums[headIndex]!=val)
                headIndex++;
            while(headIndex<=tailIndex&&nums[tailIndex]==val)
                tailIndex--;
            if(headIndex<=tailIndex)
                nums[headIndex++]=nums[tailIndex--];
        }
        return headIndex;
    }
}
