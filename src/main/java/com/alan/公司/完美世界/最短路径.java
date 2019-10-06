package com.alan.公司.完美世界;

import java.util.*;

public class 最短路径 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int[] dis = new int[6];
        dis[0] = 0;
        for (int i = 1; i < 6; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int curr = 0;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            for (int i = 0; i < 6; i++) {
                if (i == curr) continue;
                else if (arr[curr][i] > 0) {
                    dis[i] = Math.min(dis[i], dis[curr] + arr[curr][i]);
                    queue.offer(i);
                }
            }
        }
        for (int i = 1; i < 6; i++) {
            System.out.println(dis[i]);
        }
    }
}
