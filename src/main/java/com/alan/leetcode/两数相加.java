package com.alan.leetcode;

class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int flag=0,v1,v2,v;
        while(l1!=null || l2!=null){
            if(l1==null) v1=0;
            else{v1=l1.val;l1=l1.next;}
            if(l2==null) v2=0;
            else{v2=l2.val;l2=l2.next;}
            v=v1+v2+flag;
            System.out.println(v);
            flag=v/10;
            System.out.println("flag"+flag);
            curr.next=new ListNode(v%10);
            curr=curr.next;
        }
        System.out.println("flag2"+flag);
        if(flag>0)
            curr.next=new ListNode(flag);
        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }