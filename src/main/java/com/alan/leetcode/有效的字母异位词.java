package com.alan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                int val = map.get(ch);
                if (val < 1)
                    return false;
                else {
                    map.put(ch, --val);
                }
            } else
                return false;
        }
        return true;
    }
}
