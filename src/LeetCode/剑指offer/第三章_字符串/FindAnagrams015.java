package LeetCode.剑指offer.第三章_字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhiPengZhang
 * @date 2022/11/15 20:53
 * @description
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 变位词 指字母相同，但排列不同的字符串。
 **/
public class FindAnagrams015 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
        List<Integer> arrayList = new ArrayList<>();
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            hash1[p.charAt(i) - 'a']++;
            hash2[s.charAt(i) - 'a']++;
        }
        int i = 0;
        int j = p.length() - 1;
        while (j < s.length() - 1) {
            if (Arrays.equals(hash1, hash2)) {
                arrayList.add(i);
            }
            hash2[s.charAt(i++) - 'a']--;
            hash2[s.charAt(++j) - 'a']++;
        }
        if (Arrays.equals(hash1, hash2)) {
            arrayList.add(i);
        }
        return arrayList;
    }
}
