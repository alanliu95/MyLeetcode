package com.alan.公司.携程;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m, int[] array) {
        if (array == null || array.length == 0) return 0;
        return new Main().dfs(m, array);

    }

    private int res = Integer.MAX_VALUE;

    public int dfs(int m, int[] array) {
        Stack<Integer> stack = new Stack<>();
        dfsCore(m, array, 0, 0, stack);
        return res;
    }

    public void dfsCore(int m, int[] array, int times, int index, Stack stack) {
        if (times == m - 1) {
            int temp = findMax(m, array, stack);
            if (temp == Integer.MAX_VALUE)
                return;
            else {
                res = Math.min(res, temp);
                return;
            }
        }
        if (index == array.length) {
            return;
        }
        if (index < array.length) {
            //选
            stack.push(index);
            dfsCore(m, array, times + 1, index + 1, stack);
            stack.pop();
            //不选
            dfsCore(m, array, times, index + 1, stack);
        }
    }

    public int findMax(int m, int[] array, Stack stack) {
        ArrayList<Integer> list = new ArrayList<>(stack);
        Collections.sort(list);
        list.add(array.length - 1);
        // System.out.println(list);
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int start, end;
            int temp = 0;
            if (i == 0) start = -1;
            else start = list.get(i - 1);
            end = list.get(i);
            for (int j = start + 1; j <= end; j++) {
                temp += array[j];
            }

            sum = Math.max(sum, temp);
        }
        //System.out.println(sum);
        return sum;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m, array);
        System.out.println(res);
    }
}
