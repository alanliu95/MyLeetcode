package com.alan.公司.腾讯;

import java.util.Scanner;

//势力值比较大，需要使用long
public class 打怪兽 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] d = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(new 打怪兽().answer(n, d, p));
    }

    private int minCost = Integer.MAX_VALUE;

    public int answer(int n, int[] d, int[] p) {
        dfs(n, d, p, 0, 0, 0);
        return minCost;
    }

    public void dfs(int n, int[] d, int[] p, int currN, int currSum, int currCost) {
        if (currN == n) {
            minCost = Math.min(minCost, currCost);
            return;
        }
        //不买
        if (currSum - d[currN] >= 0)
            dfs(n, d, p, currN + 1, currSum - d[currN], currCost);
        //买
        dfs(n, d, p, currN + 1, currSum + d[currN], currCost + p[currN]);
    }
}
