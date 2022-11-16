package LeetCode.剑指offer.第一章_整数;

/**
 * @author ZhiPengZhang
 * @date 2022/11/3 20:34
 * @description 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 **/
public class AddBinary002 {
    public static void main(String[] args) {
        System.out.println(addBinary("1", "111"));
    }
    public static String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        StringBuilder stringBuilder = new StringBuilder();
        int flag = 0;
        for (int i = 1; i <= len; i++) {
            int numa = i <= a.length() ? a.charAt(a.length() - i) - '0' : 0;
            int numb = i <= b.length() ? b.charAt(b.length() - i) - '0' : 0;
            int result = numa + numb + flag;
            stringBuilder.append(result >= 2 ? result - 2 : result);
            flag = result >= 2 ? 1 : 0;
        }
        if (flag == 1) {
            stringBuilder.append("1");
        }
        return stringBuilder.reverse().toString();
    }
}
