package LeetCode.数组.二分搜索;
/**
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
请必须使用时间复杂度为 O(log n) 的算法。
*/
public class Search_Insert_Position_35 {
    //二分
    public static int searchInsert_Solution_1(int[] nums, int target) {
        int left = 0;
        int right=nums.length-1;
        int middle;
        while(left<=right){
            middle = (left+right)/2;
            if(nums[middle]==target)
                return middle;
            else if(nums[middle]>target)
                right=middle-1;
            else
                left=middle+1;
        }
        return left;
    }
    public static void main(String[] args) {
        int[] array={1,3,3,6,7,8};
        int target = 5;
        int answer=searchInsert_Solution_1(array,target);
        for (int i:array )
        {
            System.out.print(i+ " ");
        }
        System.out.println("\n"+answer);
    }
}
