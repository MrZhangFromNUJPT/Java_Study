package LeetCode.链表;
/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * */
public class Remove_Nth_Node_From_End_of_List_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        ListNode virtualHead = new ListNode();
        virtualHead.next = head;
        ListNode fastIndex = virtualHead;
        ListNode slowIndex = virtualHead;
        for(int i=0;i<=n;i++) fastIndex = fastIndex.next;
        while(fastIndex!=null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
        slowIndex.next = slowIndex.next.next;
        return virtualHead.next;
    }
}
