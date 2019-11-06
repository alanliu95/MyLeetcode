package com.alan.leetcode;

public class 岛屿数量 {
    private int cnt = 0;

    //private boolean[][] visited;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    explore(i, j, grid);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(" " + grid[i][j]);
            }
            System.out.println();
        }
        return cnt;
    }

    public void explore(int row, int col, char[][] grid) {
        if (col >= grid[0].length || row >= grid.length || col < 0 || row < 0) return;
        if (grid[row][col] != '1') return;
        grid[row][col] = '2';
        explore(row + 1, col, grid);
        explore(row, col + 1, grid);
        explore(row - 1, col, grid);
        explore(row, col - 1, grid);
    }
}
