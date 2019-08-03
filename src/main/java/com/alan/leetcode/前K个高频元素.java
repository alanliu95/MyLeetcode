package com.alan.leetcode;
import java.util.*;
public class 前K个高频元素 {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map=new HashMap<>();
            for(int key:nums){
                map.put(key,map.getOrDefault(key,0)+1);
            }
            PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{return map.get(a)-map.get(b);});
            for(int key:map.keySet()){
                pq.add(key);
                if(pq.size()>k)
                    pq.poll();
            }
            return new ArrayList<Integer>(pq);
        }
    }
}
