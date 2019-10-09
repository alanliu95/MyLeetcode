package com.alan.leetcode;

public class 最长回文子串 {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if (s.length() < 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 0, ii = 0, jj = 0;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    ii = i;
                    jj = j;
                }
            }
        }
        return s.substring(ii, jj + 1);
    }

    public String longestPalindrome_中心扩展法(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2; //为什么是这个确定的
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
