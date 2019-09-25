package com.alan.公司.美团.秋招2019;

import java.util.ArrayList;
import java.util.Scanner;

public class 种花 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(new 种花().delete(arr, 0, arr.length - 1));
    }

    public static int delete(int[] arr, int lo, int hi) {
        if (lo > hi) return 0;
        if (hi == lo) return arr[hi];
        int res = 0;
        int l = lo, r = lo;
        ArrayList<Integer> isZero = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (arr[i] == 0) isZero.add(i);
            if (arr[i] > 0)
                min = Math.min(min, arr[i]);
        }
        if (isZero.isEmpty()) {
            for (int i = lo; i <= hi; i++) {
                arr[i] -= min;
            }
            res += min;
            res += delete(arr, lo, hi);
        } else {
            //只分割
            int left = lo;
            for (int i = 0; i < isZero.size(); i++) {
                res += delete(arr, left, isZero.get(i) - 1);
                left = isZero.get(i) + 1;
            }
            res += delete(arr, isZero.get(isZero.size() - 1) + 1, hi);
        }
        return res;


    }
}
