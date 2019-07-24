package com.alan.leetcode;

import java.util.Stack;

//322. 零钱兑换
public class 零钱兑换 {
        public int coinChange(int[] coins, int amount) {
            if(amount<0) return -1;
            int[] dp=new int[amount+1];
            dp[0]=0;
            for(int i=1;i<=amount;i++){
                dp[i]=Integer.MAX_VALUE;
                for(int coin:coins){
                    if(i-coin<0) continue;
                    if(dp[i-coin]==Integer.MAX_VALUE)
                        continue;
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
                //System.out.println(dp[i]);

            }
//            Stack<Integer>
            if(dp[amount]==Integer.MAX_VALUE) return -1;
            return dp[amount];

        }
    }
