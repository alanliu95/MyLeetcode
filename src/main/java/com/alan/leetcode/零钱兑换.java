package com.alan.leetcode;

import java.util.Stack;

//322. 零钱兑换
public class 零钱兑换 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] coins = new int[]{1, 2, 5};
        int amount = 100;
        System.out.println(new 零钱兑换().dfs(coins, amount));
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }

    /**
     * dp[i] 记录i需要的最小硬币数，需初始化dp[0]=0
     * 如果dp[i]==Integer.MAX_VALUE 表示i无法用硬币拼出
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //特殊情况
        if (amount < 0) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE)  // dp[i-coin] 值存在 才能进行
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    private int min = Integer.MAX_VALUE;
    //DFS

    /**
     * 效率非常低的dfs
     * [1,2,5]
     * 100
     * 该用例需要跑十五分钟，非常慢
     *
     * @param coins
     * @param amount
     * @return
     */
    public int dfs(int[] coins, int amount) {
        dfsCore(coins, amount, 0, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfsCore(int[] coins, int amount, int curr, int level) {
        if (curr == amount) {
            min = Math.min(min, level);
            return;
        } else if (curr > amount) {
            return;
        }
        if (level > min) return;
        for (int coin : coins) {
            dfsCore(coins, amount, curr + coin, level + 1);
        }
    }

    //BFS
    public int bfs(int coins, int amount) {
        return 0;
    }
}
