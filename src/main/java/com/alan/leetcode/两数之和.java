package com.alan.leetcode;
import java.util.*;
/*
* 1.两数之和
* 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
* 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int[] result={0,0};
        Map map= new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {

                result[0]=i;
                result[1]=(Integer) map.get(target-nums[i]);
                return result;
            }
            else
                map.put(nums[i],i);
        }
        return result;
    }
}
