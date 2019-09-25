package com.alan.leetcode;

import java.util.Scanner;

public class 最长公共子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
//        System.out.println("a:"+a+" b:"+b);
        System.out.println(longestCommonSubsequent(a, b));
    }

    //无解情况下返回值 与 初始值 是否一致，不一致需要处理
    private static int maxLen = 0;

    public static int longestCommonSubsequent(String a, String b) {
        int rows = a.length();
        int cols = b.length();
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a.charAt(i) == b.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else {
                    dp[i + 1][j + 1] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
                maxLen = Math.max(maxLen, dp[i + 1][j + 1]);
            }
        }
        return maxLen;
    }
}
