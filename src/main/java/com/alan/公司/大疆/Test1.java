package com.alan.公司.大疆;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        while (N>0){
            int num=in.nextInt();
            int x=in.nextInt();
            int[] cj=new int[num];
            int[] time=new int[num];
            int tmp=num;
            for (int i = 0; i <num ; i++) {
                cj[i]=in.nextInt();
                time[i]=in.nextInt();
            }
            int res=new Test1().find(cj,time,x);
            System.out.println(res);
            //打印结果
            N--;
        }
    }
    public int find(int[] cj,int[] time, int x){
        Game[] arr=new Game[cj.length];
        for (int i = 0; i <cj.length ; i++) {
            arr[i]=new Game(cj[i],time[i]);
        }
        Arrays.sort(arr);
        int res=0;
        for (int i = 0; i <cj.length ; i++) {
            res+=x/arr[i].day*arr[i].cj;
            x=x%arr[i].day;
            if(x==0) break;
        }
        return res;
    }
}

class Game implements Comparable<Game> {
    int cj;
    int day;

    public Game(int cj, int day) {
        this.cj = cj;
        this.day = day;
    }
    @Override
    public int compareTo(Game o){
        Double a=1.0*cj/day;
        Double b=1.0*o.cj/o.day;
        return b.compareTo(a);
    }
}