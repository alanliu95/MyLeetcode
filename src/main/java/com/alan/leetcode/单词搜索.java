package com.alan.leetcode;

public class 单词搜索 {
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
                if (exist(0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(int currIndex, int row, int col) {
        if (currIndex == word.length()) {
            return true;
        }
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        if (booleans[row][col]) return false;
        if (board[row][col] == word.charAt(currIndex)) {
            booleans[row][col] = true;
            if (exist(currIndex + 1, row + 1, col) || exist(currIndex + 1, row - 1, col)
                    || exist(currIndex + 1, row, col + 1) || exist(currIndex + 1, row, col - 1)) {
                return true;
            }
            booleans[row][col] = false;
        }
        return false;
    }

}
