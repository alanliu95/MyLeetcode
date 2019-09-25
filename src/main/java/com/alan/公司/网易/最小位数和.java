package com.alan.公司.网易;

import java.util.Scanner;

public class 最小位数和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(answer(scanner.nextInt()));
        }
    }

    public static String answer(int x) {
        int cnt = 0;
        while (x > cnt * 9) {
            cnt++;
        }
        if (x == cnt * 9) {
            String str = "";
            for (int i = 0; i < cnt; i++) {
                str += 9;
            }
            return str;
        } else {
            int low = x - (cnt - 1) * 9;
            String str = "" + low;
            for (int i = 0; i < cnt - 1; i++) {
                str += 9;
            }
            return str;
        }

    }
}
