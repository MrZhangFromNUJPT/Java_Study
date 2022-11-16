package LeetCode.链表;
/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * */
public class Linked_List_Cycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slowIndex = head;
        ListNode fastIndex = head;
        while (fastIndex != null) {
            slowIndex = slowIndex.next;
            if (fastIndex.next != null)
                fastIndex = fastIndex.next.next;
            else
                return false;
            if (slowIndex == fastIndex) return true;
        }
        return false;
    }
}
