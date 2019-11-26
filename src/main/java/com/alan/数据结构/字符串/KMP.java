package com.alan.数据结构.字符串;

/**
 * KMP算法实现
 */
public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X];   //匹配失败
            dfa[pat.charAt(j)][j] = j + 1; //匹配成功
            X = dfa[pat.charAt(j)][X]; //更新重启状态
        }
    }

    public int search(String txt) {
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++)
            j = dfa[txt.charAt(i)][j];
        if (j == M) return i - M; //找到，返回索引
        else return N; //未找到
    }

    public static void main(String[] args) {
        KMP kmp = new KMP("abc");
        System.out.println(kmp.search("abaabc"));
    }
}
