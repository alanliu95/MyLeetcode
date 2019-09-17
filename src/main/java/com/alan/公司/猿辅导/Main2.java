package com.alan.公司.猿辅导;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }


        int res = 0, sum = 0, left = 0, right = 0;
        while (right < n) {
            if (sum <= s) {
                sum += nums[right++];
            } else {
                res = Math.max(res, right - left);
                sum -= nums[left++];
            }
//            System.out.println("1:"+right);
        }
//        System.out.println("2:"+right);
        if (right == n) {
            if (sum <= s)
                res = Math.max(res, right - left);
            else res = Math.max(res, right - left - 1);
        }

        System.out.println(res);
    }
}
