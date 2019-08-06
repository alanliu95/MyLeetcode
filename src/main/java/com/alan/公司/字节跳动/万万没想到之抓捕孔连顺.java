package com.alan.公司.字节跳动;


import java.util.Scanner;
import java.util.Stack;

public class 万万没想到之抓捕孔连顺 {
    static int res=0;
    static int d;
    static int n;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        n= in.nextInt();
        d=in.nextInt();

        int[] street=new int[n];
        for (int i = 0; i <n ; i++) {
            street[i]=in.nextInt();
        }

        find(street,new Stack<Integer>(),0);
        System.out.println(res);
        in.close();
    }
    public static void find(int[] arr, Stack<Integer> path, int cnt){
        if(cnt==3){
            int i=path.pop();
            int m=path.pop();
            int j=path.pop();
            if(arr[i]-arr[j]<=d)
                res++;
            path.push(j);
            path.push(m);
            path.push(i);
            return;
        }
        int curr=path.size()==0?0:path.peek()+1;
        for (int i = curr; i <n ; i++) {
            path.push(i);
            find(arr,path,cnt+1);
            path.pop();
        }
    }


    public static class Main {
        static long res=0;
        static int d;
        static int n;
        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            n= in.nextInt();
            d=in.nextInt();
            if(n<=2){
                System.out.println(0);
                return;
            }
            int[] arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=in.nextInt();
            }
            int j=0;
            for(int i=2;i<n;i++){
                while(arr[i]-arr[j]>d){
                    j++;
                }
                res+=compute(i-j);
            }
            //find(arr,new Stack<Integer>(),0);
            System.out.println(res%99997867);
            in.close();
        }
        public static long compute(long j){
            return j*(j-1)/2;
        }
    }

}
