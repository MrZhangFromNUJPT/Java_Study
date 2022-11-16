package LeetCode.链表;

import java.util.List;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 */
public class Swap_Nodes_in_Pairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode virtualHead = new ListNode();
        virtualHead.next = head;
        ListNode pre = virtualHead;
        ListNode cur = head;
        head = head.next;
        while(true){
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
            if(pre.next==null||pre.next.next==null) break;
            else cur = cur.next;
        }
        return head;
    }
}
