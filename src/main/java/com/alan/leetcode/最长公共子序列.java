package com.alan.leetcode;

import java.util.Scanner;

public class 最长公共子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine().toLowerCase();
        String b = scanner.nextLine().toLowerCase();
        System.out.println((a + b).length() - longestCommonSubsequence(a, b) * 2);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for (int i = 1; i < s1.length + 1; i++) {
            for (int j = 1; j < s2.length + 1; j++) {
                //如果末端相同
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //如果末端不同
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length][s2.length];
    }
}


//
//    //无解情况下返回值 与 初始值 是否一致，不一致需要处理
//    private static int maxLen = 0;
//
//    public static int longestCommonSubsequent(String a, String b) {
//        int rows = a.length();
//        int cols = b.length();
//        int[][] dp = new int[rows + 1][cols + 1];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (a.charAt(i) == b.charAt(j))
//                    dp[i + 1][j + 1] = dp[i][j] + 1;
//                else {
//                    dp[i + 1][j + 1] = Math.max(dp[i - 1][j], dp[i][j + 1]);
//                }
//                maxLen = Math.max(maxLen, dp[i + 1][j + 1]);
//            }
//        }
//        return maxLen;
//    }