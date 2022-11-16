package LeetCode.数组.移除元素;
/**
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。
*/
public class Move_Zeroes_283 {
    public void moveZeroes_1(int[] nums) {
        int slowIndex = 0;
        for(int fastIndex = 0;fastIndex<nums.length;fastIndex++){
            if(nums[fastIndex]!=0)
                nums[slowIndex++]=nums[fastIndex];
        }
        while(slowIndex<nums.length)
            nums[slowIndex++]=0;
    }
}
