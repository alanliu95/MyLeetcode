package com.alan.面试指南;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 邮局选址问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = scanner.nextInt();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = scanner.nextInt();
        }
        System.out.println(new 邮局选址问题().solution(n, num, pos));
    }

    private int min = Integer.MAX_VALUE;

    public int solution(int n, int num, int[] pos) {
        List<Integer> list = new ArrayList<>();
        solutionCore(n, num, pos, 0, 0, list);
        return min;
    }

    public void solutionCore(int n, int num, int[] pos, int cost, int level, List<Integer> list) {
        if (level == num) {
            int preIndex = list.get(list.size() - 1);
            int preVal = pos[preIndex];
            for (int i = preIndex + 1; i < n; i++) {
                cost += pos[i] - preVal;
            }
            min = Math.min(min, cost);
            return;
        }
        if (list.size() > 0) {
            int preIndex = list.get(list.size() - 1);
            int preVal = pos[preIndex];
            for (int i = preIndex + 1; i < n; i++) {
                int tmp = 0;
                for (int j = preIndex + 1; j <= i; j++) {
                    tmp += Math.min(pos[j] - preVal, pos[i] - pos[j]);
                }
                list.add(i);
                solutionCore(n, num, pos, cost + tmp, level + 1, list);
                list.remove(list.size() - 1);
            }

        } else { //第一次选取邮局
            for (int i = 0; i < (n - num); i++) {
                int tmp = 0;
                for (int j = 0; j <= i; j++) {
                    tmp += pos[i] - pos[j];
                }
                list.add(i);
                solutionCore(n, num, pos, cost + tmp, level + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
