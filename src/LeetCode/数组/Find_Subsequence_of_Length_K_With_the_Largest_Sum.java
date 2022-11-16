package LeetCode.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ZhiPengZhang
 * @date 2022/11/5 21:28
 * @description
 **/
public class Find_Subsequence_of_Length_K_With_the_Largest_Sum {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] pair = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            pair[i][0]=nums[i];
            pair[i][1]=i;
        }
        Arrays.sort(pair, (o1, o2) -> o2[0]-o1[0]);
        Arrays.sort(pair, 0, k, Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];
        for(int i =0;i<k;i++){
            result[i]=pair[i][0];
        }
        return result;
    }
}
