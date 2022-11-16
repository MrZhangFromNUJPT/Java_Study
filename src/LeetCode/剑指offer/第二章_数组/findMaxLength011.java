package LeetCode.剑指offer.第二章_数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhiPengZhang
 * @date 2022/11/11 20:46
 * @description 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 **/
@SuppressWarnings("all")
public class findMaxLength011 {

    public static void main(String[] args) {
        findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0});
    }

    public static int findMaxLength(int[] nums) {
        int length = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        hashMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!hashMap.containsKey(2 * sum - i - 1)) {
                hashMap.put(2 * sum - i - 1, i);
            } else {
                int left = hashMap.get(2 * sum - i - 1);
                length = length > (i - left) ? length : i - left;
            }
        }
        return length;
    }
}
