package LeetCode.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        int[][] hashTable = new int[strs.length][26];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++)
                hashTable[i][strs[i].charAt(j) - 'a']++;
        }
        boolean[] hashTable2 = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (hashTable2[i] != true) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashTable2[i] = true;
                for (int j = i + 1; j < strs.length; j++) {
                    if (Arrays.equals(hashTable[i], hashTable[j])) {
                        list.add(strs[j]);
                        hashTable2[j] = true;
                    }
                }
                answer.add(list);
            }
        }
        return answer;
    }
}
