package com.yang.leetcode.editor.cn;

/**
 * @author shenqiuyang3
 * @date 2020/12/17 17:36
 * @Description 翻转指定范围的链表
 */
public class ReverseSelectedList {

    private static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reversList(ListNode head, int m, int n) {

//        ListNode dummy = new ListNode(0);  //虚拟头结点往往是有必要的，好处非常明显
//        dummy.next = head;
//        ListNode pre = dummy;
//        for(int i = 1; i < m; i++){
//            pre = pre.next;
//        }
//        head = pre.next;
//        for(int i = m; i < n; i++){
//            ListNode nex = head.next;
//            head.next = nex.next;
//            nex.next = pre.next;
//            pre.next = nex;
//        }
//        return dummy.next;


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        head = pre.next;

        for (int i = m; i < n; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        //测试,建立6个listnode结点对应的val依次为1、2、3、4、5、6
        //最终让3到5的位置的链表发生反转，并重新打印出反转后的元素
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        new ReverseSelectedList().reversList(a, 3, 5);
        while (a.next != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
