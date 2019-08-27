package com.alan.公司.京东;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] peo = new int[num];
        for (int i = 0; i < num; i++) {
            peo[i] = scanner.nextInt();
        }
        int min = 0;
        int res = 0;
        while (min < num - 1) {
            min = findMin(peo, 0, num - 1);
            res++;
            min = findMin(peo, min + 1, num - 1);
        }
        System.out.println(res + 1);
    }

    public static int findMin(int[] num, int sta, int end) {
        if (num == null) return -1;
        int res = sta;
        int cur = sta;
        while (cur <= end) {
            if (num[res] <= num[cur]) {
                cur++;

            } else {
                res = cur;
                cur++;
            }
        }
        return res;
    }

}
