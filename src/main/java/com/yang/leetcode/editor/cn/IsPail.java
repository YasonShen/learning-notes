package com.yang.leetcode.editor.cn;

/**
 * @author shenqiuyang3
 * @date 2021/1/21 11:28
 * @Description
 */
public class IsPail {

    public boolean isPail (ListNode head) {
        // write code here
        ListNode reverseHead = reverse(head);

        while(head != null && reverseHead != null){
            if(head.val != reverseHead.val){
                return false;
            }else{
                head = head.next;
                reverseHead = reverseHead.next;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        if(head == null) return null;

        ListNode pre = null;
        ListNode curr = head;

        while(curr != null){
            ListNode nex = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nex;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;

        boolean pail = new IsPail().isPail(a);
        System.out.println(pail);


//        while (d != null){
//            System.out.println(d.val);
//            d = d.next;
//        }
    }
}
