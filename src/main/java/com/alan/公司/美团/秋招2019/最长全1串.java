package com.alan.公司.美团.秋招2019;

import java.util.ArrayList;
import java.util.Scanner;

public class 最长全1串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        //boolean[] arr=new boolean[n];
        ArrayList<Integer> zeroPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.nextInt() == 0)
                zeroPos.add(i);
        }
        int max = 0;
        if (k >= zeroPos.size()) {
            System.out.println(n);
            return;
        }
        //       Integer[] zeros=(Integer[])zeroPos.toArray();
        int left = 0;
        int right = k + 1;
        max = zeroPos.get(k);
        //right++;
        while (right < zeroPos.size()) {
            max = Math.max(max, zeroPos.get(right) - zeroPos.get(left) - 1);
            left++;
            right++;
        }
        System.out.println(max);
    }
}
