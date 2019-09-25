package com.alan.公司.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[][] arr = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextDouble();
            }
        }
        new Main().solution(arr, arr.length);
    }

    private double max = -1;
    private List<Integer> reslist;

    public void solution(double[][] arr, int n) {
        boolean[] used = new boolean[n];
        List<Integer> list = new ArrayList<>();
        solution(arr, n, 0, list, used);
        System.out.printf("%.2f", max);
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " " + (reslist.get(i) + 1));
        }
    }

    public void solution(double[][] arr, int n, int cnt, List list, boolean[] used) {
        if (cnt == n) {
            double temp = 0;
            for (int i = 0; i < n; i++) {
                temp += arr[i][(Integer) list.get(i)];
            }
            if (temp > max) {
                max = temp;
                reslist = new ArrayList<>(list);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i] == false) {
                used[i] = true;
                list.add(i);
                solution(arr, n, cnt + 1, list, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
