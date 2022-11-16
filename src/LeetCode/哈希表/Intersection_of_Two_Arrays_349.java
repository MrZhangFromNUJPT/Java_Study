package LeetCode.哈希表;

import java.util.*;

/**
 * 给定两个数组 nums1和nums2 ，返回它们的交集 。输出结果中的每个元素一定是唯一的。我们可以不考虑输出结果的顺序 。
 */
public class Intersection_of_Two_Arrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++)
            if (!hashSet.contains(nums1[i]))
                hashSet.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++)
            if (hashSet.contains(nums2[i]))
                hashSet2.add(nums2[i]);
        int[] ans = new int[hashSet2.size()];
        int len = 0;
        for (int next : hashSet2)
            ans[len++] = next;
        return ans;
    }
}
