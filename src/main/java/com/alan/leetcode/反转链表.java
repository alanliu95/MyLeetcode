package com.alan.leetcode;

public class 反转链表 {
}

class Solution {
    private ListNode dummy= new ListNode(0);
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode tail=reverse(head);
        tail.next=null;
        return dummy.next;
    }
    private ListNode reverse(ListNode node){
        if(node==null)
            return dummy;
        ListNode tail=reverse(node.next);
        tail.next=node;
        return node;
    }
}

//递归
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head==null|| head.next==null) return head;
        ListNode p= reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }
}

//迭代
class Solution3 {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        //ListNode dummy=new Node(0);
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode tmp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=tmp;
        }
        return pre;
    }
}