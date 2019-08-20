package com.alan.公司;

import java.util.Scanner;

public class Note {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] notes=new int[n+1];
        notes[0]=0;
        for (int i = 1; i <n+1 ; i++) {
            notes[i]=scanner.nextInt();
        }
        if(n== 1){
            System.out.print(notes[1]+" "+1);
            return;
        }
        if(n== 2){
            System.out.print(Math.max(notes[1],notes[2])+" "+1);
            return;
        }
        int[] dp=new int[n+1];
        int[] count=new int[n+1];
        count[1]=1;count[2]=1;
        dp[0]=0; dp[1]=notes[1];
        for (int i = 2; i <n+1 ; i++) {
            //dp[i]=Math.max(dp[i-1],notes[i]+dp[i-2]);
            if(dp[i-1]>notes[i]+dp[i-2]){
                dp[i]=dp[i-1];
            }
            else if(dp[i-1]<notes[i]+dp[i-2]){
                dp[i]=notes[i]+dp[i-2];
            }else {
                dp[i]=dp[i-1];
                count[i]=Math.min(count[i-1],1+count[i-2]);
            }
        }
        System.out.print(dp[n]+" "+count[n]);

    }

}
//7
//        1 3 2 1 3 4 7