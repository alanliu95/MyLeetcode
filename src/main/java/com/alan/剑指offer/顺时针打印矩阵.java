package com.alan.剑指offer;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    private ArrayList<Integer> res;
    int rows;
    int cols;

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        res = new ArrayList<Integer>();
        if (matrix == null) return res;
        int start = 0;
        rows = matrix.length;
        cols = matrix[0].length;

        while (start * 2 < rows && start * 2 < cols) {
            print(start++, matrix);
        }
        return res;
    }

    public void print(int start, int[][] matrix) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        for (int i = start; i <= endX; i++)
            res.add(matrix[start][i]);
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++)
                res.add(matrix[i][endX]);
        }
        if (endX > start && endY > start) {
            for (int i = endX - 1; i >= start; i--) {
                res.add(matrix[endY][i]);
            }
        }

        if (endX > start && endY - start > 1) {
            for (int i = endY - 1; i > start; i--) {
                res.add(matrix[i][start]);
            }
        }
    }
}
