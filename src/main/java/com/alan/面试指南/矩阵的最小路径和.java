package com.alan.面试指南;

import java.util.Scanner;

public class 矩阵的最小路径和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //scanner.nextLine();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }
        System.out.println(new 矩阵的最小路径和().findMinPath(mat));
    }

    private int min = -1;

    public int findMinPath(int[][] mat) {
        findMinPath(mat, mat.length, mat[0].length, 0, 0, 0);
        return min;
    }

    public void findMinPath(int[][] mat, int rows, int cols, int row, int col, int cnt) {
        if (row >= rows || col >= cols) return;
        //    if(row<0||col<0) return;
        if (row == rows - 1 && col == cols - 1) {
            cnt += mat[rows - 1][cols - 1];
            min = min == -1 ? cnt : Math.min(min, cnt);
            return;
        }
        findMinPath(mat, rows, cols, row + 1, col, cnt + mat[row][col]);
        findMinPath(mat, rows, cols, row, col + 1, cnt + mat[row][col]);
    }

    public int dp(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        if (rows == 1 && cols == 1) return mat[0][0];
        int[][] dp = new int[rows][cols];

        dp[0][0] = mat[0][0];
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + mat[0][i];
        }

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + mat[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + mat[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
