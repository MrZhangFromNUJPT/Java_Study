package LeetCode.哈希表;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */
public class Find_All_Anagrams_in_a_String_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] hashTableOfp = new int[26];
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String str = s.substring(i, i + p.length());
            if (isAnagram(str, p))
                list.add(i);
        }
        return list;
    }

    public boolean isAnagram(String s, String t) {
        int[] hashTable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hashTable[s.charAt(i) - 'a']++;
            hashTable[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (hashTable[i] != 0)
                return false;
        return true;
    }
}
