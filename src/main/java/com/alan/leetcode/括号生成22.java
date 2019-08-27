package com.alan.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 括号生成22 {
    public static void main(String[] args) {
        //Scanner scanner=new Scanner(System.in);
        List<String> result = new 括号生成22().generateParenthesis(3);
        System.out.println(result);
    }

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        dfs(n, 0, 0, "");
        return result;
    }

    public void dfs(int n, int left, int right, String str) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left < n)
            dfs(n, left + 1, right, str + '(');
        if (right < left)
            dfs(n, left, right + 1, str + ')');
    }
}
