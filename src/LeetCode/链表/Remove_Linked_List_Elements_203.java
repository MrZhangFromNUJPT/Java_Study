package LeetCode.链表;

/**
 * 给你一个链表的头节点head和一个整数val，请你删除链表中所有满足Node.val == val 的节点，并返回新的头节点。
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Remove_Linked_List_Elements_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode beforeHead = new ListNode();
        beforeHead.next = head;
        ListNode first = beforeHead;
        ListNode second = head;
        while (second != null){
            if(second.val==val){
                first.next = second.next;
                second = second.next;
            }
            else{
                first = first.next;
                second = second.next;
            }
        }
            return beforeHead.next;
    }

    //递归
    public ListNode removeElements_2(ListNode head, int val) {
        if(head==null) return null;
        head.next = removeElements_2(head.next,val);
        return head.val==val?head.next:head;
    }
}