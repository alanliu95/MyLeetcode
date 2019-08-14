package com.alan.公司;

import java.util.Scanner;

public class 进出水 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int t=scanner.nextInt();
        int m1=scanner.nextInt();
        int t1=scanner.nextInt();
        int m2=scanner.nextInt();
        int t2=scanner.nextInt();
        int curr=0;
        for (int i = 1; i <=t ; i++) {
            if((i%t1==0&&i/t1%2==1)||(i%t1!=0&&i/t1%2==0)){
                curr+=m1;
            }
            if((i%t2==0&&i/t2%2==1)||(i%t2!=0&&i/t2%2==0)){
                curr-=m2;
            }
            if(curr<0) curr=0;
            if(curr>m) curr=m;

        }
        System.out.println(curr);
    }
}
