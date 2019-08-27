package com.alan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //如果当前数字大于0，则无结果，结束
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1, R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //跳过重复元素
                    while (L + 1 < R && nums[L + 1] == nums[L]) L++;
                    while (R - 1 > L && nums[R - 1] == nums[R]) R--;
                    L++;
                    R--;
                } else if (sum < 0) {
                    //去重
                    while (L < R && nums[L] == nums[++L]) ;
                } else {
                    //去重
                    while (L < R && nums[R] == nums[--R]) ;
                }
            }
        }
        return res;
    }


//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res=new ArrayList<>();
//        if(nums==null||nums.length==0) return res;
//        Arrays.sort(nums);
//        threeSum(nums,0,0,new Stack<Integer>(),res);
//        return res;
//    }
//    public void threeSum(int[] nums, int index,int cnt, Stack<Integer> stack, List res){
//        if(cnt==3){
//            int i=0;
//            for(int e:stack){
//                i+=e;
//            }
//            if(i==0)
//                res.add(new ArrayList<>(stack));
//            return;
//        }
//        for (int i = index; i <nums.length ; i++) {
//            if (i > index && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            stack.push(nums[i]);
//            threeSum(nums,i+1,cnt+1,stack,res);
//            stack.pop();
//        }
//    }
}
