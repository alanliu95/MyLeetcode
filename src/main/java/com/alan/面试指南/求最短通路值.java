package com.alan.面试指南;

//https://www.nowcoder.com/practice/b83cfe486b494a398609d18b94fb04d3


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 求最短通路值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        boolean[][] mat = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            //System.out.println(line);
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '1') {
                    mat[i][j] = true;
                }
            }
        }
        System.out.println(new 求最短通路值().bfs(mat));
    }

    private int min = -1;

    /**
     * DFS穷举 用例过40%
     *
     * @param mat
     * @return
     */
    public int findMinPath(boolean[][] mat) {
        findMinPath(mat, mat.length, mat[0].length, 0, 0, 0);
        return min;
    }

    public void findMinPath(boolean[][] mat, int rows, int cols, int row, int col, int cnt) {
        if (row >= rows || col >= cols) return;
        if (row < 0 || col < 0) return;
        if (row == rows - 1 && col == cols - 1) {
            min = min == -1 ? cnt + 1 : Math.min(min, cnt + 1);
            return;
        }
        if (min > 0 && cnt > min)
            return;
        if (mat[row][col]) {
            mat[row][col] = false;
            findMinPath(mat, rows, cols, row + 1, col, cnt + 1);
            findMinPath(mat, rows, cols, row - 1, col, cnt + 1);
            findMinPath(mat, rows, cols, row, col + 1, cnt + 1);
            findMinPath(mat, rows, cols, row, col - 1, cnt + 1);
            mat[row][col] = true;
        }
    }

    public int bfs(boolean[][] mat) {
        if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0)
            return 0;
        int n = mat.length;
        int m = mat[0].length;
        int[][] map = new int[n][m];
        map[0][0] = 1;
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> cQ = new LinkedList<>();
        rQ.offer(0);
        cQ.offer(0);
        int r = 0, c = 0;
        while (!rQ.isEmpty()) {
            r = rQ.poll();
            c = cQ.poll();
            if (r == n - 1 && c == m - 1) {
                return map[r][c];
            }
            bfsCore(mat, map, map[r][c], r + 1, c, rQ, cQ);
            bfsCore(mat, map, map[r][c], r - 1, c, rQ, cQ);
            bfsCore(mat, map, map[r][c], r, c + 1, rQ, cQ);
            bfsCore(mat, map, map[r][c], r, c - 1, rQ, cQ);

        }
        return -1;
    }

    public void bfsCore(boolean[][] mat, int[][] map, int pre, int toR, int toC, Queue rQ, Queue cQ) {
        if (toR < 0 || toR == map.length || toC < 0 || toC == map[0].length || map[toR][toC] != 0 || mat[toR][toC] == false)
            return;
        map[toR][toC] = pre + 1;
        rQ.offer(toR);
        cQ.offer(toC);
    }
}
