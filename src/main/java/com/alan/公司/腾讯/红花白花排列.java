package com.alan.公司.腾讯;

import java.util.Scanner;

public class 红花白花排列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] ab = new int[t][2];
        for (int i = 0; i < t; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }
        for (int i = 0; i < t; i++) {
            System.out.println(new 红花白花排列().answer(k, ab[i][0], ab[i][1]));
        }

    }

    public int answer(int k, int left, int right) {
        int res = right - left + 1;
        for (int i = left; i <= right; i++) {
            int times = i / k;
            for (int j = 1; j <= times; j++) {
                if (i - j * k == 0) continue;
                dfs(j + 1, i - j * k);
                res += dfsResult;
//                int pos=j+1;
//                int remain=i-j*k;

            }
        }
        return res;
    }

    int dfsResult;

    public void dfs(int pos, int remain) {
        dfsResult = 0;
        dfsCore(pos, remain, 0, 1);
    }

    public void dfsCore(int pos, int remain, int times, int currPos) {

        if (remain == 0) {
            dfsResult++;
            return;
        }
        for (int i = currPos; i <= pos; i++) {
            dfsCore(pos, remain - 1, times + 1, i);
            if (i + 1 <= pos)
                dfsCore(pos, remain - 1, times + 1, i + 1);
        }

    }
}
