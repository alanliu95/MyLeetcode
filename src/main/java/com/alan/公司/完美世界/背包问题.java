package com.alan.公司.完美世界;

import java.util.Scanner;

public class 背包问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int time[] = new int[n];
        int cj[] = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cj[i] = scanner.nextInt();
        }
        System.out.println(new 背包问题().dp(cj, time, x));
    }

    public int dp(int[] cj, int[] time, int x) {
        if (cj == null || cj.length == 0 || x <= 0) return 0;
        int[][] dp = new int[cj.length][x + 1];
        for (int i = 0; i <= x; i++) {
            if (i >= time[0]) dp[0][i] = cj[0];
        }
        for (int i = 1; i < cj.length; i++) {
            for (int j = 0; j <= x; j++) {
                //i>0
                int no = dp[i - 1][j];
                int yes = Integer.MIN_VALUE;
                if (j >= time[i])
                    yes = cj[i] + dp[i - 1][j - time[i]];
                dp[i][j] = Math.max(no, yes);
            }
        }
        return dp[cj.length - 1][x];
    }

}
