package com.yang.leetcode.editor.cn;

/**
 * @author shenqiuyang3
 * @date 2021/1/6 9:27
 * @Description
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class ReverseListNode {

    public static ListNode reverseListNodeRecur(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode ret = reverseListNodeRecur(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }

    public static ListNode reverseNonRecur(ListNode head){
        ListNode pre = null,cur = head,next = null;

        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void printListNode(ListNode head){
        if (head == null) return;

        printListNode(head.next);

        System.out.println(head.val);
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = b;

//        ListNode listNode = new RotateListNode().rotateListNode(a, 2);
//        new ReverseListNode().printListNode(a);

        ListNode listNode = reverseNonRecur(a);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
