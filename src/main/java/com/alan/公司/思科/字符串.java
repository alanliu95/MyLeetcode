package com.alan.公司.思科;

import java.util.Scanner;

public class 字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();

        if (ip.indexOf("\"") != -1)
            ip.replace("\"", "");
        if (ip.indexOf("<") > -1) {
            ip = ip.substring(0, ip.indexOf("<"));
            //ip=ip.substring(ip.substring(">"))
        }

        System.out.println(ip);
    }
}
