package com.yang.leetcode.editor.cn;

/**
 * @author shenqiuyang3
 * @date 2021/1/24 15:46
 * @Description
 */
public class RotateListNode {

    public ListNode rotateListNode(ListNode head, int k){

        ListNode pre = head;
        ListNode dummyHead = head;
        while (k-- > 0 && dummyHead != null){
            dummyHead = dummyHead.next;
        }
        while (dummyHead.next != null){
            pre = pre.next;
            dummyHead = dummyHead.next;
        }
        ListNode newHead = dummyHead.next;
        ListNode dummy = newHead;
        while (dummy.next != null){
            dummy = dummy.next;
        }
        pre.next = null;
        dummy.next = head;
        return newHead;
    }


}
