package LeetCode.字符串;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Replace_spaces_Offer05 {
    //库函数
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    //使用一个新的对象，复制 str，复制的过程对其判断，是空格则替换，否则直接复制，类似于数组复制
    public static String replaceSpace_2(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    //双指针
    public static String replaceSpace_3(String s) {
        int numOfSpace = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ' ')
                numOfSpace++;
        char[] str = new char[s.length() + 2 * numOfSpace];
        int i = s.length() - 1;
        int j = str.length - 1;
        while (i >= 0) {
            if (s.charAt(i) != ' ')
                str[j--] = s.charAt(i--);
            else {
                str[j--] = '0';
                str[j--] = '2';
                str[j--] = '%';
                i--;
            }
        }
        return new String(str);
    }
}
