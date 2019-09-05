package com.alan.公司.携程;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class 表达式解析 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String str) {
        char[] arr = str.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '(') stack.push(i);
            else if (arr[i] == ')') {
                if (stack.isEmpty()) {
                    return "";
                }
                int left = stack.pop();
                reverse(arr, left, i);

            }

        }
        String res = "";
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
            if (arr[i] != '(' && arr[i] != ')') res += arr[i];
        }
        return res;
    }

    public static void reverse(char[] arr, int left, int right) {
        if (left >= right) return;
        for (int i = left; i <= (left + right) / 2; ++i) {
            char temp = arr[left - i + right];
            arr[left - i + right] = arr[i];
            arr[i] = temp;
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
