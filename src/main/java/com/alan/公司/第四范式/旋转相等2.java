package com.alan.公司.第四范式;

import java.util.Scanner;

public class 旋转相等2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        if (str1.length() != str2.length()) {
            System.out.println(false);
            return;
        } else {
            if ((str1 + str1).indexOf(str2) != -1) {
                System.out.println(true);
            } else
                System.out.println(false);
            return;
        }
    }

}
