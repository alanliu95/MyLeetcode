package com.alan.leetcode;

public class 搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (target > matrix[row][col])
                row++;
            else if (target < matrix[row][col])
                col--;
            else
                return true;
        }
        return false;
    }
}
