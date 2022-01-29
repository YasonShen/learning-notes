package com.yang.test;


public class ReverseOddNode {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static void mainTest(ListNode head){
        if (head == null || head.next == null){
            return;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddHead = odd;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = null;

        evenHead = reverse(evenHead);

        ListNode listNode = mergeList(oddHead, evenHead);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null){
            ListNode nex = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nex;
        }
        return pre;
    }

    private static ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        listNode.next = new ListNode(8);
        listNode = listNode.next;
        listNode.next = new ListNode(2);
        listNode = listNode.next;
        listNode.next = new ListNode(7);
        listNode = listNode.next;
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(6);
        listNode = listNode.next;
        listNode.next = new ListNode(4);
        listNode = listNode.next;
        listNode.next = new ListNode(5);

        mainTest(head);

    }
}
