package com.alan.公司.猿辅导;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int[][] arr=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        ArrayList<Integer> res = new Main().printMatrix(arr);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        //System.out.println();
    }

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
//        for (int i = start; i <= endX; i++)
////            res.add(matrix[start][i]);
        for (int i = start; i <= endY; i++)
            res.add(matrix[i][start]);

//        if (endY > start) {
//            for (int i = start + 1; i <= endY; i++)
//                res.add(matrix[i][endX]);
//        }
        if (endX > start) {
            for (int i = start + 1; i <= endX; i++)
                res.add(matrix[endY][i]);
        }

//        if (endX > start && endY > start) {
//            for (int i = endX - 1; i >= start; i--) {
//                res.add(matrix[endY][i]);
//            }
//        }

        if (endX > start && endY > start) {
            for (int i = endY - 1; i >= start; i--) {
                res.add(matrix[i][endX]);
            }
        }

        if (endX > start && endY - start > 1) {
            for (int i = endX - 1; i > start; i--) {
                res.add(matrix[start][i]);
            }
        }
    }
}

