package com.alan.公司.浦发银行;

import java.util.Scanner;

public class 子串拼成原串 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int N = str.length();
        System.out.println(new 子串拼成原串().process(str, N));

    }

    public boolean process(String str, int N) {
        String dual = str + str;
        for (int i = 1; i <= N; ++i) {
            if (dual.substring(i, i + N).equals(str)) {
                System.out.println("子串为" + dual.substring(0, i));
                return true;
            }
        }
        return false;
    }
}
