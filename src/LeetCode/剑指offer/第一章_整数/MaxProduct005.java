package LeetCode.剑指offer.第一章_整数;

/**
 * @author ZhiPengZhang
 * @date 2022/11/5 20:41
 * @description 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。
 * 假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 **/
public class MaxProduct005 {
    public int maxProduct(String[] words) {
        int[] flag = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flag[i] |= 1 << (c - 'a');
            }
        }
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((flag[i] & flag[j]) == 0) {
                    len = Math.max(len, words[i].length() * words[j].length());
                }
            }
        }
        return len;
    }
}
