package LeetCode.哈希表;

import java.util.*;

/**
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 */
public class Intersection_of_Two_Arrays_II_350 {
    //用了两个HashMap和一个set
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        a(nums1, hashMap1);
        a(nums2, hashMap2);
        Set<Integer> set = hashMap1.keySet();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : set) {
            if (hashMap2.containsKey(i)) {
                int count = Math.min(hashMap1.get(i), hashMap2.get(i));
                for (int j = 0; j < count; j++)
                    arrayList.add(i);
            }
        }
        int[] ans = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++)
            ans[i] = arrayList.get(i);
        return ans;
    }

    public void a(int[] nums2, HashMap<Integer, Integer> hashMap2) {
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap2.containsKey(nums2[i])) {
                int count = hashMap2.get(nums2[i]);
                hashMap2.replace(nums2[i], count + 1);
            } else
                hashMap2.put(nums2[i], 1);
        }
    }

    //官方，只用一个HashMap，学会map.getOrDefault()和Arrays.copyOfRange()方法
    public int[] intersect_2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect_2(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
