package com.alan.公司.五八同城;

import java.util.Scanner;

public class 邮箱添加掩码 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String prefix = str.substring(0, str.indexOf("@"));
        String suffix = str.substring(str.indexOf("@"), str.length());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < prefix.length(); i++) {
            builder.append(prefix.charAt(i));
            if (i == prefix.length() - 1) continue;
            builder.append("MASK".charAt(i % 4));
        }
        System.out.println(builder.toString() + suffix);
    }
}
