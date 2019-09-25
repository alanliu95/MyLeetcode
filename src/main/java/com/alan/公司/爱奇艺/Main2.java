package com.alan.公司.爱奇艺;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int len = (int) Math.pow(2, n);
        int[] seq = new int[len];
        int[][] ch = new int[m][2];
        for (int i = 0; i < len; i++) {
            seq[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            ch[i][0] = scanner.nextInt() - 1;
            ch[i][1] = scanner.nextInt();
        }
        int last = -1;
        for (int i = 0; i < m; i++) {
            if (seq[ch[i][0]] == ch[i][1] && last > -1) {
                System.out.println(last);
                continue;
            }
            seq[ch[i][0]] = ch[i][1];
            int res = new Main2().solution(seq, n);
            last = res;
            System.out.println(res);
        }

    }

    private boolean useOr = true;
    private int res = 0;
    private int[][] mid;
    private boolean isFirst = true;

    public int solution(int[] seq, int n) {
        mid = new int[n][seq.length];
        solutionCore(seq);
        return res;
    }

    public void solutionCore(int[] seq) {
        if (seq.length == 1) {
            res = seq[0];
            return;
        }
        int[] newArr = new int[seq.length / 2];
        if (useOr) {
            for (int i = 0, j = 0; i < seq.length; i += 2, j++) {
                newArr[j] = seq[i] | seq[i + 1];
            }
        } else {
            for (int i = 0, j = 0; i < seq.length; i += 2, j++) {
                newArr[j] = seq[i] ^ seq[i + 1];
            }
        }
        useOr = !useOr;
        solutionCore(newArr);

    }
}
