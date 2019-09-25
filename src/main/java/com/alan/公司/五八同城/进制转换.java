package com.alan.公司.五八同城;

import java.util.Scanner;

public class 进制转换 {
    public static final char[] table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '`', '!', '@', '#', '$', '%', '^', '&', '*', '(',
            ')', '{', '}', '\\', '<', '>', '?',};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long val = scanner.nextLong();
        boolean flag = false;
        if (val < 0) {
            flag = true;
            val = -val;
        }
        if (val == 0) {
            System.out.println(0);
            return;
        }
        String str = "";
        while (val != 0) {
            int last = (int) (val % 27);
            str = table[last] + str;
            val = val / 27;
        }
        if (flag) System.out.print("-");
        System.out.println(str);
    }
}
