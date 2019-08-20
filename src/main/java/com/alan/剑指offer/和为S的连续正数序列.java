package com.alan.剑指offer;

import java.util.ArrayList;

public class 和为S的连续正数序列 {
    public class Solution {
        public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer> > ();
            int small=1,big=2;
            while(small<big){
                int tmp=(small+big)*(big-small+1)/2;
                if(tmp<sum) big++;
                else if(tmp>sum) small++;
                else{
                    res.add(getList(small,big));
                    small++;
                }
            }
            return res;
        }
        public ArrayList<Integer> getList(int small, int big){
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=small;i<=big;i++){
                list.add(i);
            }
            return list;
        }
    }
}
