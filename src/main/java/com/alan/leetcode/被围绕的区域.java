package com.alan.leetcode;

public class 被围绕的区域 {
    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0) return;
        int cols = board[0].length;
        boolean[][] isUsed = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            dfs(board, rows, cols, i, 0, isUsed);
            dfs(board, rows, cols, i, cols - 1, isUsed);
        }
        for (int i = 0; i < cols; i++) {
            dfs(board, rows, cols, 0, i, isUsed);
            dfs(board, rows, cols, rows - 1, i, isUsed);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!isUsed[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int rows, int cols, int row, int col, boolean[][] isUsed) {
        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return;
        if (isUsed[row][col]) return;
        if (board[row][col] == 'O') {
            isUsed[row][col] = true;
            dfs(board, rows, cols, row + 1, col, isUsed);
            dfs(board, rows, cols, row - 1, col, isUsed);
            dfs(board, rows, cols, row, col + 1, isUsed);
            dfs(board, rows, cols, row, col - 1, isUsed);
        } else {
            return;
        }
    }
}
