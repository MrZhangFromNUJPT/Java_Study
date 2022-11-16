package LeetCode.链表;
/**
 * 给定一个链表的头节点head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 不允许修改链表
 * */
public class Linked_List_Cycle_II_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slowIndex = head;
        ListNode fastIndex = head;
        while (fastIndex != null) {
            slowIndex = slowIndex.next;
            if (fastIndex.next != null)
                fastIndex = fastIndex.next.next;
            else
                return null;
            if (slowIndex == fastIndex) break;
        }
        if(fastIndex!=null){
            slowIndex = head;
            while(fastIndex!=slowIndex){
                fastIndex = fastIndex.next;
                slowIndex = slowIndex.next;
            }
            return slowIndex;
        }
        else return null;
    }
}
