package com.alan.leetcode;

public class 旋转数组 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        //数组长度小于1
        if (len <= 1) return;
        //k 大于数组长度，取模
        k = k % len;
        swap(nums, 0, len - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, len - 1);
    }

    public void swap(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }

}
