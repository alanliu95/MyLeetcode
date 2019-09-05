package com.alan.leetcode;

import java.util.Arrays;

public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        Arrays.sort(dp);
        return dp[n - 1];
    }
}