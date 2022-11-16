package LeetCode.栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 */
public class Implement_Stack_using_Queues_225 {
}

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!queue1.isEmpty())
            queue1.offer(x);
        else
            queue2.offer(x);
    }

    public int pop() {
        if (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                int temp = queue1.poll();
                if (queue1.isEmpty())
                    return temp;
                else
                    queue2.offer(temp);
            }
        } else {
            while (!queue2.isEmpty()) {
                int temp = queue2.poll();
                if (queue2.isEmpty())
                    return temp;
                else
                    queue1.offer(temp);
            }
        }
        return 0;
    }

    public int top() {
        if (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                int temp = queue1.poll();
                queue2.offer(temp);
                if (queue1.isEmpty())
                    return temp;
            }
        } else {
            while (!queue2.isEmpty()) {
                int temp = queue2.poll();
                queue1.offer(temp);
                if (queue2.isEmpty())
                    return temp;
            }
        }
        return 0;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}