package com.alan.leetcode;

import java.util.Arrays;

public class 打家劫舍II {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int myRob(int[] nums) {
        int prevMax = 0, currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(x + prevMax, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}

