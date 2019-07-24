package com.alan.leetcode;

public class 不相交的线 {
    public static void main(String[] args) {



    }
}class Solution_不相交的线 {
    public int maxUncrossedLines(int[] A, int[] B) {

        //就是最长公共子序列

        int len1 = A.length;
        int len2 = B.length;

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];

    }



}
