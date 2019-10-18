package com.alan.公司.携程;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main3 {
    public static boolean filt(String network, String maskIp) {
        //首先将网段转换为10进制数
        String[] networks = network.split("\\.");
        long networkIp = Long.parseLong(networks[0]) << 24 |
                Long.parseLong(networks[1]) << 16 |
                Long.parseLong(networks[2]) << 8 |
                Long.parseLong(networks[3]);

        //取出网络位数
        int netCount = Integer.parseInt(maskIp.replaceAll(".*/", ""));
        //这里实际上通过CIDR的网络号转换为子网掩码
        int mask = 0xFFFFFFFF << (32 - netCount);

        //再将验证的ip转换为10进制数
        String testIp = maskIp.replaceAll("/.*", "");
        String[] ips = testIp.split("\\.");
        long ip = Long.parseLong(ips[0]) << 24 |
                Long.parseLong(ips[1]) << 16 |
                Long.parseLong(ips[2]) << 8 |
                Long.parseLong(ips[3]);

        //将网段ip和验证ip分别和子网号进行&运算之后，得到的是网络号，如果相同，说明是同一个网段的
        return (networkIp & mask) == (ip & mask);
    }

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean CheckBlackList(String userIP, String blackIP) {
        long ip = ipValue(userIP);
        long netLow = 0, netHigh = 0;
        if (blackIP.contains("/")) {
            return filt(userIP, blackIP);
        } else {
            netLow = ipValue(blackIP);
            if (ip == netLow)
                return true;
        }
        return false;

    }

    static boolean CheckBlackList2(String userIP, String blackIP) {
        long ip = ipValue(userIP);
        long netLow = 0, netHigh = 0;
        netLow = ipValue(blackIP.substring(0, blackIP.indexOf("/")));
        if (blackIP.indexOf("/") >= 0) {
            netLow = ipValue(blackIP.substring(0, blackIP.indexOf("/")));
            int maskCnt = Integer.parseInt(blackIP.substring(blackIP.indexOf("/") + 1));
            int mask = 1;
            for (int i = 0; i <= maskCnt; i++) {
                mask *= 2;
            }
            mask -= 1;
            netHigh = netLow + mask;
            if (ip >= netLow && ip <= netHigh)
                return true;
        } else {
            if (ip == netLow)
                return true;
        }
        return false;

    }

    static long ipValue(String ip) {
        String[] arr = ip.split("\\.");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        long res = 0;
        long weight = 1;
        for (int i = 3; i >= 0; i--) {
            long temp = Integer.parseInt(arr[i]);
            if (i != 3)
                weight = weight * 256;
            res = res + temp * weight;
        }
        return res;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean res;

        String _userIP;
        try {
            _userIP = in.nextLine();
        } catch (Exception e) {
            _userIP = null;
        }

        String _blackIP;
        try {
            _blackIP = in.nextLine();
        } catch (Exception e) {
            _blackIP = null;
        }

        res = CheckBlackList(_userIP, _blackIP);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}

