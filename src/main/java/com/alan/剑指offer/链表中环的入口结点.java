package com.alan.剑指offer;

public class 链表中环的入口结点 {
    public ListNode meetingNode(ListNode pHead){
        if(pHead==null) return null;
        ListNode slow=pHead;
        ListNode fast=pHead.next;
        while(slow!=null&&fast!=null){
            if(slow==fast) return slow;
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
        }
        return null;
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode=meetingNode(pHead);
        if(meetingNode==null) return null;
        ListNode node1=meetingNode;
        //环至少有一个节点，即相遇节点
        int n=1;
        while (node1.next!=meetingNode){
            n++;
            node1=node1.next;
        }
        node1=pHead;
        ListNode node2=pHead;
        for (int i = 0; i <n ; i++) {
            node2=node2.next;
        }
        while(node1!=node2){
            node1=node1.next;
            node2=node2.next;
        }
        return node1;
    }
}
