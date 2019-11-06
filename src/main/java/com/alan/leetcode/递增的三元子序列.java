package com.alan.leetcode;

public class 递增的三元子序列 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 0, 4, 6};
        new 递增的三元子序列().increasingTriplet(arr);
    }

    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        //dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }

            }
            if (dp[i] > 2)
                return true;
        }
        return false;
    }
}
