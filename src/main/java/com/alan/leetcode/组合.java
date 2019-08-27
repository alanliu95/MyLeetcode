package com.alan.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 组合 {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        combine(n, k, 0, new Stack<Integer>(), res);
        return res;
    }

    public void combine(int n, int k, int times, Stack<Integer> stack, ArrayList<List<Integer>> res) {
        if (times == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        int startIndex = stack.size() == 0 ? 0 : stack.peek();
        for (int i = startIndex + 1; i <= n; i++) {
            stack.push(i);
            combine(n, k, times + 1, stack, res);
            stack.pop();
        }
    }
}
