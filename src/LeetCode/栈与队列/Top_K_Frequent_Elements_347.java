package LeetCode.栈与队列;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class Top_K_Frequent_Elements_347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int j : nums) {
            int num = hashMap.getOrDefault(j, 0) + 1;
            hashMap.put(j, num);
        }
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        priorityQueue.addAll(entries);
        int[] answer = new int[k];
        int num = 0;
        for (int i = 0; i < k; i++)
            answer[num++] = priorityQueue.poll().getKey();
        return answer;
    }
}
