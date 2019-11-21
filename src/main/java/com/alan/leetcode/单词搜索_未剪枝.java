package com.alan.leetcode;

/**
 * 该方法在成功找到结果后，没有立刻停止后续无用的递归，导致时间超时
 */
public class 单词搜索_未剪枝 {
    boolean res = false;
    int rows;
    int cols;
    char[][] board;
    boolean[][] booleans;
    String word;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        this.word = word;
        this.board = board;
        this.booleans = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                exist(0, i, j);
                if (res) return true;
            }
        }
        return false;
    }

    private void exist(int currIndex, int row, int col) {
        if (currIndex == word.length()) {
            res = true;
            return;
        }
        if (row < 0 || row >= rows || col < 0 || col >= cols) return;
        if (booleans[row][col]) return;
        if (board[row][col] == word.charAt(currIndex)) {
            booleans[row][col] = true;
            exist(currIndex + 1, row + 1, col);
            exist(currIndex + 1, row - 1, col);
            exist(currIndex + 1, row, col + 1);
            exist(currIndex + 1, row, col - 1);
            booleans[row][col] = false;
        } else {
            return;
        }
    }
}
