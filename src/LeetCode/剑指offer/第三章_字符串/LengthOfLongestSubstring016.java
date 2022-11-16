package LeetCode.剑指offer.第三章_字符串;

/**
 * @author ZhiPengZhang
 * @date 2022/11/15 21:06
 * @description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 **/
public class LengthOfLongestSubstring016 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        //由英文字母、数字、符号和空格组成 就是ASCII码上常见的前128个
        int[] hash = new int[128];
        int left = 0;
        int right = -1;
        //记录不符合要求的字符个数
        int countDup = 0;
        while (right < s.length() - 1) {
            hash[s.charAt(++right)]++;
            if (hash[s.charAt(right)] == 2) {
                countDup++;
            }
            while (left <= right && countDup > 0) {
                hash[s.charAt(left++)]--;
                if (hash[s.charAt(right)] == 1) {
                    countDup--;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
