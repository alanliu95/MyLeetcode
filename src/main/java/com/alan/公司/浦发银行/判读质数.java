package com.alan.公司.浦发银行;

public class 判读质数 {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        } else {
            int a = (int) Math.sqrt(n);
            for (int i = 2; i <= a; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
