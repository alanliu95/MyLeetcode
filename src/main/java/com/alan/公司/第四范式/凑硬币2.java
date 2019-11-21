package com.alan.公司.第四范式;

import java.util.Scanner;

public class 凑硬币2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        int coins[] = new int[(int) k];
        for (int i = 0; i < k; i++) {
            coins[i] = scanner.nextInt();
        }
        System.out.println(change(n, coins));
    }

    public static long change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        long[] dp = new long[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount] % 1000000007L;

    }

}
