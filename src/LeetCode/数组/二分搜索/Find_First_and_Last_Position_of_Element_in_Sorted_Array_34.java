package LeetCode.数组.二分搜索;

/**
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回[-1, -1]。
进阶：
你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
*/
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34 {

    //遍历数组
    public int[] searchRange(int[] nums, int target) {
        int[] answer = {-1, -1};
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] != target)
                i++;
            else
                answer[0] = i;
            if (nums[j] != target)
                j--;
            else
                answer[1] = j;
            if (i <= j)
                if (nums[i] == target && nums[j] == target && answer[0] != -1 && answer[1] != -1)
                    break;
        }
        return answer;
    }






    //二分搜索
    public int[] searchRange_2(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一:target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
        if (leftBorder < -1 || rightBorder >nums.length) return new int[]{-1, -1};
        // 情况二:target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
        //情况三:target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
        return new int[]{-1, -1};
    }

    private int getRightBorder(int[] nums, int target) {//找到第一个大于target的数的位置
        int left = 0;
        int right = nums.length - 1;
        int rightBorder;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target)
                right = middle - 1;
            else {
                left = middle + 1;
            }
        }
        rightBorder = left;
        return rightBorder;
    }

    private int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int leftBorder;
        while(left<=right){
            int middle = (left+right)/2;
            if(nums[middle]<target)
                left = middle+1;
            else{
                right = middle-1;
            }
        }
        leftBorder=right;
        return leftBorder;
    }
}
