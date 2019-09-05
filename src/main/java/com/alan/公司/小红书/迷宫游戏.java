package com.alan.公司.小红书;

import java.util.Scanner;

public class 迷宫游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[][] arr = new boolean[n][n];
        int sx = 0, sy = 0;
        int ex = 0, ey = 0;
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            //System.out.println(str);
            char[] chars = str.toCharArray();

            for (int j = 0; j < n; j++) {
                char ch = chars[j];
                if (ch == 'S') {
                    sx = i;
                    sy = j;
                }
                if (ch == 'E') {
                    ex = i;
                    ey = j;
                }
                if (ch == '#') {
                    arr[i][j] = true;
                }
            }
            scanner.nextLine();
        }
//        System.out.println("起点"+sx+" "+sy);
//        System.out.println("终点"+ex+" "+ey);
        System.out.println(new 迷宫游戏().dfs(n, arr, sx, sy, ex, ey));
    }

    private int min = Integer.MAX_VALUE;

    int dfs(int n, boolean[][] arr, int currX, int currY, int eX, int eY) {
        boolean[][] used = new boolean[n][n];
        dfsCore(n, arr, currX, currY, eX, eY, 0, used);
        if (min == Integer.MAX_VALUE)
            return -1;
        else
            return min;
    }

    void dfsCore(int n, boolean[][] arr, int currX, int currY, int eX, int eY, int cnt, boolean[][] used) {
        if (currX == eX && currY == eY) {
            min = Math.min(min, cnt);
        }
        if (currX < 0) currX = arr.length - 1;
        if (currX == arr.length) currX = 0;
        if (currY < 0) currY = arr.length - 1;
        if (currY == arr.length) currY = 0;
        //用过 或者是障碍
        if (used[currX][currY] || arr[currX][currY])
            return;
        used[currX][currY] = true;
        dfsCore(n, arr, currX + 1, currY, eX, eY, cnt + 1, used);
        dfsCore(n, arr, currX - 1, currY, eX, eY, cnt + 1, used);
        dfsCore(n, arr, currX, currY + 1, eX, eY, cnt + 1, used);
        dfsCore(n, arr, currX, currY - 1, eX, eY, cnt + 1, used);
        used[currX][currY] = false;

    }
}
