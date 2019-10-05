package com.alan.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中的第K个最大元素 {
    public static void main(String[] args) {
        System.out.println(new 数组中的第K个最大元素().findKthLargest(new int[]{3,2,1,5,6,4},2));;
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int ele:nums) {
            if(pq.isEmpty()) pq.add(ele);
            else if(pq.size()<k){
                pq.add(ele);
            }else if(ele>pq.peek()){
                pq.remove();
                pq.add(ele);
            }
        }
        return pq.peek();
    }
}
