package com.alan.公司.美团.秋招2019;

import java.util.Scanner;

public class 外卖满减 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int price : prices) {
            sum += price;
        }
        boolean[] dp = new boolean[sum + 1];
        //Arrays.sort(prices);
        //帮助实现只用一种菜品的情况
        dp[0] = true;
        for (int price : prices) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (dp[j]) dp[j + price] = true;
            }
        }
        for (int i = x; i < dp.length; i++) {
            if (dp[i]) {
                System.out.println(i);
                return;
            }
        }
    }

}
