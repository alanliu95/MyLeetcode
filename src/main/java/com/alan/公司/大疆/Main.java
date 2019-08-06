package com.alan.公司.大疆;

import java.util.Scanner;

public class Main {

    private int max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();  //case数

        while (T-- > 0) {

            int N = scanner.nextInt(); //游戏数目
            int X = scanner.nextInt(); //总时间

            int[] cj = new int[N];
            int[] time = new int[N];
            for (int i = 0; i < N; i++) {
                cj[i] = scanner.nextInt();
                time[i] = scanner.nextInt();
            }
            Main ai = new Main();
            ai.dfs(0, N,X ,0, cj, time);
            System.out.println(ai.max);

        }


    }

    public void dfs(int i, int N, int remain, int cnt, int[] cj, int[] time) {
        if (i == N) {
            max = Math.max(max, cnt);
            return;
        }
        //要
        if (remain - time[i] >= 0)
            dfs(i + 1, N, remain - time[i], cnt+cj[i], cj, time);
        //不要
        dfs(i + 1, N, remain, cnt, cj, time);

    }
}