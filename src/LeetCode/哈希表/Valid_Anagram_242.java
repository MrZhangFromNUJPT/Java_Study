package LeetCode.哈希表;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 */
public class Valid_Anagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
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
