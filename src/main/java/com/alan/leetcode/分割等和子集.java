package com.alan.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class 分割等和子集 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,5,11,5};
        System.out.println(new 分割等和子集().canPartition(arr));
    }
    public boolean canPartition(int[] nums) {
        if(nums==null||nums.length<2) return false;
        int sum=0;
        for(int e:nums){
            sum+=e;
        }
        if(sum%2==1) return false;
        int n=nums.length;
        int target=sum/2;
        boolean dp[][]=new boolean[n][target+1];
        dp[0][nums[0]]=true;
        dp[0][0]=true;
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <=target ; j++) {
                if(dp[i-1][j]) dp[i][j]=true;
                else if(j>nums[i]) dp[i][j]=dp[i-1][j-nums[i]];
            }

        }
        return dp[n-1][target];
    }
}
