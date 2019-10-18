package com.alan.公司.浦发银行;

public class 回文素数 {
    public static void main(String[] args) {

    }

    public int primePalindrome(int L, int R) {
        int cnt = 0;
        for (int i = L; i <= R; i++) {
            if (isPrimeAndPalidrome(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isPrimeAndPalidrome(int N) {
        boolean isPrime = true, isPalindrome = true;

        // 判断是否为素数
        for (int i = 2, len = (int) Math.sqrt(N); i <= len; ++i) {
            if (N % i == 0) {
                isPrime = false;
                break;
            }
        }
        // 判断是否为回文数
        String cs = String.valueOf(N);
        for (int j = 0, len = cs.length() >> 1; j < len; ++j) {
            if (cs.charAt(j) != cs.charAt(cs.length() - j - 1)) {
                isPalindrome = false;
                break;
            }
        }
        // 是回文数和素数
        if (isPrime && isPalindrome) return true;
        else return false;
    }
}
