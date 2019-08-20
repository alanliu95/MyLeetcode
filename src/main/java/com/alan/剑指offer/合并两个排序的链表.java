package com.alan.剑指offer;

public class 合并两个排序的链表 {
        public ListNode Merge(ListNode list1,ListNode list2) {
            ListNode p1=list1;
            ListNode p2=list2;
            ListNode dummy=new ListNode(0);
            ListNode res=dummy;
            while(p1!=null || p2!=null){
                int val1=Integer.MAX_VALUE,val2=Integer.MAX_VALUE;
                if(p1!=null) val1=p1.val;
                if(p2!=null) val2=p2.val;
                if(val1<=val2){
                    res.next=new ListNode(val1);
                    p1=p1.next;
                }
                else {
                    res.next=new ListNode(val2);
                    p2=p2.next;
                }
                res=res.next;
            }
            return dummy.next;
        }

}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}