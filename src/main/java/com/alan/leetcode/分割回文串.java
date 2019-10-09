package com.alan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
    public static void main(String[] args) {
        System.out.println(new 分割回文串().partition("aabb"));
    }


    public List<List<String>> partition_DP(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int length = s.length();
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
        return partitionHelper(s, 0, dp);
    }

    private List<List<String>> partitionHelper(String s, int start, boolean[][] dp) {
        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                String left = s.substring(start, i + 1);
                for (List<String> l : partitionHelper(s, i + 1, dp)) {
                    l.add(0, left);
                    ans.add(l);
                }
            }

        }
        return ans;
    }

    /**
     * 分治法
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            List<String> list = new ArrayList<>();
            List<List<String>> res = new ArrayList<>();
            res.add(list);
            return res;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1); //如果 lastIndex 等于 beginIndex，该方法返回值将是？
            if (isPalindrome(sub)) {
                for (List<String> ele : partition(s.substring(i + 1))) {
                    ele.add(0, sub);
                    ans.add(ele);
                }
            }
        }
        return ans;

    }

    public boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
