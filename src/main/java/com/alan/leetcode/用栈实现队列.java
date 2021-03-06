package com.alan.leetcode;

import java.util.Stack;

public class 用栈实现队列 {
}

class MyQueue {
    Stack<Integer> s1=new Stack();
    Stack<Integer> s2=new Stack();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    private void refresh(){
        //System.out.println(s1.size());
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            // size在push()被调用后改变
            // for(int i=0;i<s1.size();i++){
            //     //System.out.println(s1.peek());
            //     s2.push(s1.pop());
            // }
        }
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        refresh();
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        refresh();
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (s1.empty() && s2.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */