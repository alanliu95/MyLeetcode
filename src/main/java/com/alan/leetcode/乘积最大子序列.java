package com.alan.leetcode;

import java.util.Map;

public class 乘积最大子序列 {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], nums[i] * min);
            res = Math.max(max, res);
        }
        return res;
    }
}
