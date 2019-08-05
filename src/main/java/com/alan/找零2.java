package com.alan;

import java.util.Scanner;

public class 找零2 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int target=1024-n;
        if(target==0){
            System.out.println(0);
            return;
        }
        int[] dp=new int[target+1];
        int[] coins=new int[]{1,4,16,64};
        dp[0]=0;dp[1]=1;dp[2]=2; dp[3]=3; dp[4]=1;dp[16]=1;dp[64]=1;
        for (int i = 5; i <=target ; i++) {
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i<coins[j]) continue;
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
            //dp[i]=
        }
        for (int i = 0; i <=target ; i++) {
            System.out.print(dp[i]+" ");
        }

    }
    public static class Main {
        public static void main(String[] args) {
            Scanner in= new Scanner(System.in);
            int n=in.nextInt();
            int target=1024-n;
            if(target==0){
                System.out.println(0);
                return;
            }
            int[] dp=new int[target+1];
            int[] coins=new int[]{1,4,16,64};
            dp[0]=0;dp[1]=1;dp[2]=2; dp[3]=3; dp[4]=1;dp[16]=1;dp[64]=1;
            for (int i = 5; i <=target ; i++) {
                dp[i]=Integer.MAX_VALUE;
                for(int j=0;j<coins.length;j++){
                    if(i<coins[j]) continue;
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
                //dp[i]=
            }
            System.out.println(dp[target]);
        }
    }
}
