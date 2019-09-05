package com.alan.公司.三六零;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 散步 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(new 散步().findEnding(N, M, arr));
    }

    private HashSet<Integer> set;

    public int findEnding(int n, int m, int[] arr) {
        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dfs(n, m, arr, 0, i);
        }
        return set.size();
    }

    public void dfs(int n, int m, int[] arr, int times, int pos) {
        if (pos < 0 || pos > n - 1)
            return;
        if (times == m) {
            set.add(pos);
            return;
        }

        dfs(n, m, arr, times + 1, pos + arr[times]);
        dfs(n, m, arr, times + 1, pos - arr[times]);
    }
}
