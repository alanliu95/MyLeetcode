package com.alan.leetcode;
/**
 * leetcode 155 最小栈
 * 最小栈，MinStack.getMin()可获取栈中最小元素
 */
class MinStack {
    private MyStack<Integer> s;
    private MyStack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        s=new MyStack<Integer>();
        min=new MyStack<Integer>();
        //min.push(Integer.MAX_VALUE);
        //System.out.println();
    }

    public void push(int x) {
        if(s.isEmpty()){
            min.push(x);
        }else{
            if(min.peek()<x)
                min.push(min.peek());
            else
                min.push(x);
        }
        s.push(x);
    }

    public void pop() {
        s.pop();
        min.pop();
    }

    public int top() {
        return s.peek();

    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

//class MyStack<Item>{
//    private class Node{
//        Item item;
//        Node next;
//    }
//    private Node first;
//    //    private Node last;
//    private int n;
//    public boolean isEmpty(){return (n==0);}
//    public void push(Item item){
//        Node oldFirst=first;
//        first=new Node();
//        first.item=item;
//        first.next=oldFirst;
//        n++;
//    }
//    public Item pop(){
//        Item item=first.item;
//        first=first.next;
//        n--;
//        return item;
//    }
//    public Item peek()
//    {
//        return first.item;
//    }
//}
