package com.alan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 多数元素169 {
    // 摩尔投票
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count = 1;
            } else if (nums[i] == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    // 哈希表
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2.0) {
                return num;
            }
        }
        return 0;
    }
}
