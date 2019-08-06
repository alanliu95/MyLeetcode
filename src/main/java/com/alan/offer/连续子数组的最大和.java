package com.alan.offer;

import java.util.Arrays;

public class 连续子数组的最大和 {
    public class Solution {
        public int FindGreatestSumOfSubArray(int[] array) {
            int N=array.length;
            if(array==null || N==0) return 0;
            int[] dp=new int[N];
            dp[0]=array[0];
            for(int i=1;i<N;i++){
                if(dp[i-1]>0)
                    dp[i]=dp[i-1]+array[i];
                else dp[i]=array[i];
            }
            Arrays.sort(dp);
            return dp[N-1];
        }
    }
}
