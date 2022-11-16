package LeetCode.栈与队列;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (c == ')') {
                if(stack.isEmpty()) return false;
                if(stack.pop()!='(') return false;
            }
            else if (c == ']') {
                if(stack.isEmpty()) return false;
                if(stack.pop()!='[') return false;
            }
            else if (c == '}') {
                if(stack.isEmpty()) return false;
                if(stack.pop()!='{') return false;
            }
        }
        return stack.isEmpty();
    }
}
