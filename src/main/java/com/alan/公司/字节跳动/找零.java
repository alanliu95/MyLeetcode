package com.alan.公司.字节跳动;

import java.util.Scanner;

public class 找零 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int target=1024-n;
        if(target==0){
            System.out.println(0);
            return;
        }
        int[] dp;
        if(target<65)
            dp=new int[65];
        else
            dp=new int[target+1];
        int[] coins=new int[]{1,4,16,64};
        //只需要初始化dp[0]
        dp[0]=0;
        for (int i = 1; i <=target ; i++) {
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i<coins[j]) continue;
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        System.out.println(dp[target]);

    }
}