package com.alan.leetcode;
import java.util.*;
import java.util.ArrayList;
import java.util.Stack;

public class 双栈排序 {
}


class TwoStacks {
    private Stack<Integer> s= new Stack<>();
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        for(int e:numbers){
            pushAndSort(e);
        }
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.addAll(s);
        return l;
    }
    private void pushAndSort(int e){
        if(s.empty()){
            s.push(e);
            return;
        }
        int e1=s.pop();
        if(e<=e1){
            s.push(e1);
            s.push(e);
        }
        else{
            pushAndSort(e);
            s.push(e1);
        }
    }
}
