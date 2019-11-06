package com.alan.leetcode;

public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            // 使用nums[i-1]
            res[i] = res[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        for (int i = len - 2; i >= 0; i--) {
            // 使用nums[i+1]
            tmp *= nums[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}
