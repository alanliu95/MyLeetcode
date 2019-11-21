package com.alan.公司.第四范式;

import java.util.Scanner;

public class 凑硬币 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        long coins[] = new long[(int) k];
        for (int i = 0; i < k; i++) {
            coins[i] = scanner.nextLong();
        }
        System.out.println(change(n, coins));
    }

    public static long change(long amount, long[] coins) {
        int len = coins.length;
        long[][] dp = new long[len + 1][(int) amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][(int) (j - coins[i - 1])];
                }
            }
        }
        return dp[len][(int) amount] / 1000000007L;
    }

}
