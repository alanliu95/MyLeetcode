package com.alan.leetcode2022;

import java.util.Stack;

public class 使括号有效的最少添加 {
    public int minAddToMakeValid(String s) {
        int result = 0, counter = 0;
        if (s == null || s.length() == 0)
            return 0;
        char[] arr = s.toCharArray();
        for (int index = 0; index < s.length(); index++) {
            if (arr[index] == '(') {
                counter++;

            } else {
                if (counter > 0)
                    counter--;
                else
                    result++;
            }

        }
        return result + counter;
    }
}
