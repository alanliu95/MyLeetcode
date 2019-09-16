package com.alan.公司.小米;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String[] input) {
        String res = "";

        for (String s : input) {

            String[] temp = s.split("\\s+");
            int[] arr = new int[temp.length];

            boolean pre = true;
            int cnt = 0;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(temp[i]);
            }

            int j = 0;
            while (j < arr.length - 1) {
                if (arr[j] == 0) {
                    ++j;
                    continue;
                }
                if (arr[j] == arr[j + 1]) {
                    res = res + (arr[j] * 2) + " ";
                    ++cnt;
                    j = j + 2;
                    if (j == arr.length - 1) {
                        res = res + arr[j] + " ";
                        ++cnt;
                    }

                } else {
                    res = res + arr[j++] + " ";
                    ++cnt;
                    if (j == arr.length - 1) {
                        res = res + arr[j] + " ";
                        ++cnt;
                    }

                }
            }
            for (int i = 1; i <= arr.length - cnt; ++i) {
                res = res + 0 + " ";
            }
            res = res.substring(0, res.length() - 1);


        }

        return res;

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for (int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        System.out.println(res);
    }
}

