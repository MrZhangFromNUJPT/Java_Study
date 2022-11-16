package LeetCode.栈与队列;

import java.util.LinkedList;

/**
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class Remove_All_Adjacent_Duplicates_In_String_1047 {
    public String removeDuplicates(String s) {
        LinkedList<Character> characters = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!characters.isEmpty() && characters.peekLast() == temp)
                characters.removeLast();
            else
                characters.offerLast(temp);
        }
        char[] str = new char[characters.size()];
        int index = 0;
        for (char i : characters) {
            str[index++] = i;
        }
        return new String(str);
    }
}
