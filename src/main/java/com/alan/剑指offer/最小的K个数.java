package com.alan.剑指offer;
import java.util.*;
public class 最小的K个数 {

    public class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            ArrayList<Integer> result=new ArrayList<>();
            if(input==null || input.length==0 || k==0 ||k>input.length) return result;
            Queue<Integer>  queue=new PriorityQueue<Integer>(k);
            for(int e:input){
                queue.add(e);
            }
            while(k>0){
                result.add(queue.remove());
                k--;
            }
            return result;
        }
    }
}
