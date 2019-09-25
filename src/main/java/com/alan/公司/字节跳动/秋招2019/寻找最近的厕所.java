package com.alan.公司.字节跳动.秋招2019;

import java.util.ArrayList;
import java.util.Scanner;

public class 寻找最近的厕所 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] arr = new boolean[n];
        ArrayList<Integer> pos = new ArrayList<>();
        scanner.nextLine();
        String str = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'O') {
                arr[i] = true;
                pos.add(i);
            }
        }
        int[] pos_arr = new int[pos.size()];
        for (int i = 0; i < pos.size(); i++) {
            pos_arr[i] = pos.get(i);
        }
        int pre = 0, post = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < pos_arr.length; j++) {
                if (pos_arr[j] >= i) {
                    if (j == 0)
                        pre = 0;
                    else
                        pre = pos_arr[j - 1];
                    post = pos_arr[j];
                }

            }
            if ((post - i) < (i - pre)) {
                builder.append(post - i);
            } else
                builder.append(i - pre);
        }
        System.out.println(builder.toString());
    }
}
