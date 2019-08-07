package com.alan.leetcode;

public class _01背包 {
    public static void main(String[] args) {
        int[] cj=new int[]{10,18,10};
        int[] time=new int[]{2,3,2};
        int x=4;
        System.out.println(new _01背包().dp(cj,time,x));
    }
    public int dp(int[] cj,int[] time,int x){
        if(cj==null||cj.length==0||x<=0) return 0;
        int[][] dp=new int[cj.length][x+1];
        for (int i = 0; i <=x; i++) {
            if(i>=time[0]) dp[0][i]=cj[0];
        }
        for (int i = 1; i <cj.length ; i++) {
            for (int j = 0; j <=x ; j++) {
                //i>0
                int no=dp[i-1][j];
                int yes=Integer.MIN_VALUE;
                if(j>=time[i])
                    yes=cj[i]+dp[i-1][j-time[i]];
                dp[i][j]=Math.max(no,yes);
            }
        }
        return dp[cj.length-1][x];
    }
}
