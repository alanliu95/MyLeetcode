package com.alan.公司.第四范式;

import java.util.Scanner;

public class 旋转相等 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(judge(str1, str2));
    }

    private static boolean judge(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.equals(str2)) {
                return true;
            }
            str1 = str1.substring(1) + str1.substring(0, 1);

        }
        return false;
    }
}
