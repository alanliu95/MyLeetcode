package com.alan.leetcode;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int ele : nums) {
            if (!set.contains(ele))
                set.add(ele);
            else return true;
        }
        return false;
    }
}
