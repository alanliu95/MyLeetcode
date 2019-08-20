package com.alan.剑指offer;

public class 链表中倒数第k个结点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        //private int k=0;
        public ListNode FindKthToTail(ListNode head,int k) {
            //存在多种特殊情况，head=null/太短{1,2,3} k=6
            if(head==null||k==0) return null;
            ListNode first=head, second=head;
            int i=k-1;
            while(i>0&&first!=null){
                first=first.next;
                i--;
            }
            if(first==null) return null;

            while(first.next!=null){  //判断条件不能为 first !=null
                first=first.next;
                second=second.next;
            }
            return second;
        }
    }
}
