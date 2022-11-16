package LeetCode.栈与队列;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 注意两个整数之间的除法只保留整数部分。
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class Evaluate_Reverse_Polish_Notation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (s.equals("-"))
                stack.push(-stack.pop() + stack.pop());
            else if (s.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (s.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            }
            else
                stack.push(Integer.valueOf(s));
        }
        return stack.pop();
    }
}
