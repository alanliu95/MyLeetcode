package com.alan.面试指南;


import java.util.Scanner;
import java.util.TreeSet;

public class 最长的可整合子数组的长度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        //int[] arr=new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
//        Integer[] arr = (Integer[]) set.toArray();
        int[] arr = new int[set.size()];
        int j = 0;
        for (int ele : set) {
            arr[j++] = ele;
            // System.out.println(ele);
        }
        int max = -1;
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == 1) {
                cnt++;
            } else {
                cnt = 1;
            }
            max = Math.max(max, cnt);

        }
        //max = max == -1 ? 1 : max;
        System.out.println(max);
    }
}