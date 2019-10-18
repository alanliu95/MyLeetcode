package com.alan.公司.携程;

import java.util.Scanner;

public class 矩阵的最小路径和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        //scanner.nextLine();
        boolean[][] mat = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextInt() == 1 ? true : false;
            }
        }
        System.out.println(new 矩阵的最小路径和().findMinPath(mat));
    }

    private int count = 0;

    public int findMinPath(boolean[][] mat) {
        findMinPath(mat, mat.length, mat[0].length, 0, 0);
        return count;
    }

    public void findMinPath(boolean[][] mat, int rows, int cols, int row, int col) {
        if (row >= rows || col >= cols) return;
        if (row == rows - 1 && col == cols - 1) {
            count++;
            return;
        }
        if (mat[row][col]) return;
        mat[row][col] = true;
        findMinPath(mat, rows, cols, row + 1, col);
        findMinPath(mat, rows, cols, row, col + 1);
        mat[row][col] = false;

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
