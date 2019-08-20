package com.alan.剑指offer;

public class 机器人的运动范围 {
    public static void main(String[] args) {
        System.out.println(new 机器人的运动范围().movingCount(10, 1, 100));
    }

    int cnt;
    boolean[][] visited;

    public int movingCount(int threshold, int rows, int cols) {
        visited = new boolean[rows][cols];
        movingCountCore(threshold, rows, cols, 0, 0);
        return cnt;
    }

    void movingCountCore(int threshold, int rows, int cols, int currRow, int currCol) {
        //System.out.println(""+currRow+currCol);
        if (currCol < 0 || currCol >= cols || currRow < 0 || currRow >= rows || sum(currRow, currCol) > threshold || visited[currRow][currCol])
            return;

        visited[currRow][currCol] = true;
        cnt++;


        movingCountCore(threshold, rows, cols, currRow, currCol + 1);
        movingCountCore(threshold, rows, cols, currRow + 1, currCol);
        //movingCountCore(threshold,rows,cols,currRow-1,currCol);
        //movingCountCore(threshold,rows,cols,currRow,currCol-1);
    }

    int sum(int currRow, int currCol) {
        int res = 0;
        while (currRow != 0) {
            res += currRow % 10;
            currRow = currRow / 10;
        }
        while (currCol != 0) {
            res += currCol % 10;
            currCol = currCol / 10;
        }
        return res;
    }
}
