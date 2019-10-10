package com.alan.leetcode;

import org.w3c.dom.html.HTMLParagraphElement;

public class 打家劫舍 {
    public int rob(int[] nums) {
        int prevMax = 0, currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(x + prevMax, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
