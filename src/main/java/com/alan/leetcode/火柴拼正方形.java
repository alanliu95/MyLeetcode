package com.alan.leetcode;

import java.util.Arrays;

public class 火柴拼正方形 {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4)
            return false;
        int sum = 0;
        for (int i : matchsticks) {
            sum += i;
        }
        if (sum % 4 != 0)
            return false;
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int len = sum / 4;
        int[] edge = new int[4];
        int i = 0;
        return dfs(i, matchsticks, edge, len);

    }

    private boolean dfs(int i, int[] matchsticks, int[] edge, int len) {
        if (i == matchsticks.length)
            return true;
        for (int j = 0; j <= edge.length; j++) {
            edge[j] += matchsticks[i];
            if (edge[j] <= len && dfs(i + 1, matchsticks, edge, len)) {
                return true;
            }
            edge[j] -= matchsticks[i];
        }
        return false;
    }
}
