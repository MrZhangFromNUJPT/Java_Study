package LeetCode.链表;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。val是当前节点的值，next是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
 * 如果index大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引index有效，则删除链表中的第index个节点。
 */
public class Design_Linked_List_707 {

}

class MyLinkedList {
    //定义节点
    public static class ListNode {
        private int val;
        private ListNode next;
    }

    private int length;
    private ListNode head;

    public MyLinkedList() {

    }

    public MyLinkedList(int length, ListNode head) {
        this.length = length;
        this.head = head;
    }

    public int get(int index) {
        if (index >= length || index < 0) {
            return -1;
        }
        ListNode listNode = this.head;
        for (int i = 0; i < index; i++) {
            listNode = listNode.next;
        }
        return listNode.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    public void addAtIndex(int index, int val) {
        //如果index大于链表长度，则不会插入节点
        if (index > length) {
            return;
        }
        //设置插入节点
        ListNode listNode = new ListNode();
        listNode.val = val;
        listNode.next = null;
        //遍历指针
        ListNode iterate;
        //如果index小于0，则在头部插入节点
        if (index <= 0) {
            listNode.next = this.head;
            this.head = listNode;
            //尾部插入
        } else if (index == length) {
            iterate = this.head;
            while (iterate.next != null) {
                iterate = iterate.next;
            }
            iterate.next = listNode;
            //其他
        } else {
            iterate = this.head;
            for (int i = 1; i < index; i++) {
                iterate = iterate.next;
            }
            listNode.next = iterate.next;
            iterate.next = listNode;
        }
        this.length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        } else if (index == 0) {
            this.head = this.head.next;
        } else {
            ListNode iterate;
            iterate = head;
            for (int i = 1; i < index; i++) {
                iterate = iterate.next;
            }
            iterate.next = iterate.next.next;
        }
        this.length--;
    }
}