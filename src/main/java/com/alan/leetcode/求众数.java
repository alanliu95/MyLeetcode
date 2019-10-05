package com.alan.leetcode;

public class 求众数 {
    public static void main(String[] args) {
        System.out.println("hello");
    }
    public int majorityElement(int[] nums) {
        int val=nums[0];
        int count=0;
        for (int ele : nums) {
            if(ele==val){
                count++;
            }else {
                count--;
                if(count==0){
                    val=ele;
                    count++;
                }
            }

        }
        return val;
    }
}
