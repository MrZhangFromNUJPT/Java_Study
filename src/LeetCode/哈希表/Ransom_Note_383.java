package LeetCode.哈希表;
/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * */
public class Ransom_Note_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        int[] hashTable = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            hashTable[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            hashTable[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (hashTable[i] < 0)
                return false;
        return true;
    }
}
