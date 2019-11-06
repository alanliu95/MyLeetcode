package com.alan.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两种方法，1. 使用hashmap ,时间复杂度 空间 O(n)
 * 2. 排序，双指针
 */
public class 两个数组的交集II {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums1) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        List<Integer> resList = new ArrayList<>();
        for (int ele : nums2) {
            if (map.containsKey(ele)) {
                int val = map.get(ele);
                if (val > 0) {
                    resList.add(ele);
                    map.put(ele, val - 1);
                }
            }
        }
        int len = resList.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
