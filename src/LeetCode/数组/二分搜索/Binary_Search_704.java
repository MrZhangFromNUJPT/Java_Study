package LeetCode.数组.二分搜索;

/**
给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
*/

public class Binary_Search_704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target)
                right = middle - 1;
            else if (nums[middle] < target)
                left = middle + 1;
            else
                return middle;
        }
        return -1;
    }
}
