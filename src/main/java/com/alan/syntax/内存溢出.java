package com.alan.syntax;

public class 内存溢出 {
    static final int SIZE = 2 * 1024 * 1024;

    public static void main(String[] a) {
        int[] i = new int[SIZE];
        System.out.println("正常退出");
    }
}