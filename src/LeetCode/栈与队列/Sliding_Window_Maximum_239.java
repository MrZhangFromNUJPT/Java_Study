package LeetCode.栈与队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。
 * 滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值 。
 */
public class Sliding_Window_Maximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1)
            return nums;
        int len = nums.length - k + 1;
        int res[] = new int[len];
        int num = 0;
        myQueue myQueue = new myQueue();
        for (int i = 0; i < k; i++)
            myQueue.add(nums[i]);
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.peek();
        }
        return res;
    }
}

class myQueue {
    private Deque<Integer> deque = new LinkedList<>();

    public void poll(int val) {
        if (!deque.isEmpty() && val == deque.getFirst())
            deque.removeFirst();
    }

    public void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast())
            deque.removeLast();
        deque.addLast(val);
    }

    public int peek() {
        return deque.getFirst();
    }
}
