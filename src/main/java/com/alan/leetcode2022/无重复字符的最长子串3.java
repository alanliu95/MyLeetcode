package com.alan.leetcode2022;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int head = 0, maxLen = 0;
        for (int tail = 0; tail < s.length(); tail++) {
            char c = s.charAt(tail);
            if (!map.containsKey(c)) {
                maxLen = Math.max(maxLen, tail - head + 1);
            } else {
                int index = map.get(c);
                // 错误写法
                // while (head < map.get(c)) {
                // "aa" 场景第二次 get操作是，报空指针
                while (head < index) {
                    map.remove(s.charAt(head));
                    head++;
                }
                head = index + 1;
            }
            map.put(c, tail);

        }
        return maxLen;
    }
}