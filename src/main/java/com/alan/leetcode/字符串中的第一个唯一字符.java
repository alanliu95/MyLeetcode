package com.alan.leetcode;

public class 字符串中的第一个唯一字符 {
    int[] map = new int[256];

    public int firstUniqChar(String s) {
        for (int i = 0; i < 256; i++) {
            map[i] = -2;
        }
        for (int i = 0; i < s.length(); i++) {
            char index = s.charAt(i);
            if (map[index] == -2) {
                map[index] = i;
            } else if (map[index] >= 0) {
                map[index] = -1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char index = s.charAt(i);
            if (map[index] >= 0)
                return i;
        }
        return -1;
    }
}
