package com.alan.offer;

public class 复杂链表的复制 {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public class Solution {
        public RandomListNode Clone(RandomListNode pHead)
        {
            if(pHead==null) return null;
            return cloneNodes(pHead);
        }
        public RandomListNode cloneNodes(RandomListNode pHead){
            RandomListNode Head=pHead;
            while(Head!=null){
                RandomListNode tmp=Head.next;
                Head.next=new RandomListNode(Head.label);
                Head.next.next=tmp;
                Head=tmp;
            }
            Head=pHead;
            while(Head!=null){
                if(Head.random!=null)
                    Head.next.random=Head.random.next;
                Head=Head.next.next;
            }
            Head=pHead;
            RandomListNode result=pHead.next;
            while(Head!=null){
                RandomListNode tmp=Head.next;
                // 1-1-2-2-null  2-null检测
                if(Head.next!=null) Head.next=Head.next.next;

                Head=tmp;
            }
            return result;

        }
    }
}
