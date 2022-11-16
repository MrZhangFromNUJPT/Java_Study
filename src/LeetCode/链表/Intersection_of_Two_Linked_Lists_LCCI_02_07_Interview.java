package LeetCode.链表;
/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * */
public class Intersection_of_Two_Linked_Lists_LCCI_02_07_Interview {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode traverseA = headA;
        ListNode traverseB = headB;
        while (traverseA != null) {
            lenA++;
            traverseA = traverseA.next;
        }
        while (traverseB != null) {
            lenB++;
            traverseB = traverseB.next;
        }
        traverseA = headA;
        traverseB = headB;
        if (lenA > lenB) {
            int n = lenA - lenB;
            while (n != 0) {
                traverseA = traverseA.next;
                n--;
            }
        } else if (lenA < lenB) {
            int n = lenB - lenA;
            while (n != 0) {
                traverseB = traverseB.next;
                n--;
            }
        }
        while (traverseA != null) {
            if (traverseA == traverseB)
                return traverseB;
            traverseA = traverseA.next;
            traverseB = traverseB.next;
        }
        return null;
    }
}
