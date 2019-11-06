package com.alan.剑指offerReview;

public class 斐波那契数列 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int pre = 1, prepre = 0;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = pre + prepre;
            prepre = pre;
            pre = res;
        }
        return res;
    }
}
