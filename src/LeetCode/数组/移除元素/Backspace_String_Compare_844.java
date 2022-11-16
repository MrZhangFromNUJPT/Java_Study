package LeetCode.数组.移除元素;

import java.util.Stack;

/**
给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
注意：如果对空文本输入退格字符，文本继续为空。
*/
public class Backspace_String_Compare_844 {
    //运用栈
    public boolean backspaceCompare(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Stack<Character> stringStack1 = new Stack<>();
        Stack<Character> stringStack2 = new Stack<>();
        for(int i=0;i<sChar.length;i++){
            Character str = sChar[i];
            if(str!='#')
                stringStack1.push(str);
            else if(!stringStack1.isEmpty())
                stringStack1.pop();
        }
        for(int i=0;i<tChar.length;i++){
            Character str = tChar[i];
            if(str!='#')
                stringStack2.push(str);
            else if(!stringStack2.isEmpty())
                stringStack2.pop();
        }
        if(stringStack1.equals(stringStack2))
            return true;
        else
            return false;
    }
}
