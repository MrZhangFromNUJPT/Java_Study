package LeetCode.剑指offer.第三章_字符串;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ZhiPengZhang
 * @date 2022/11/14 20:31
 * @description 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 **/
public class CheckInclusion014 {
    @Test
    public void main() {
        System.out.println(checkInclusion("adc", "dcda"));
        ;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return false;
        }
        int[] map1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = -1;
        int[] map2 = new int[26];
        while (right < s1.length() - 1) {
            map2[s2.charAt(++right) - 'a']++;
        }
        while (right < s2.length() - 1) {
            if (Arrays.equals(map1, map2)) {
                return true;
            }
            map2[s2.charAt(++right) - 'a']++;
            map2[s2.charAt(left++) - 'a']--;
        }
        if (Arrays.equals(map1, map2)) {
            return true;
        }
        return false;
    }
}
