package com.alan.公司.字节跳动;

import java.util.Scanner;

public class 毕业旅行问题 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int path[][]=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                path[i][j]=scanner.nextInt();
            }
        }
        int res=new 毕业旅行问题().solve(n,path);
        System.out.println(res);
    }
    private boolean[] visited;
    private int lastCity;
    private int minCost;
    public int solve(int n, int[][] path){
        lastCity=0;
        minCost =Integer.MAX_VALUE;
        visited=new boolean[n];
        dfs(0,n,0,path);
        return minCost;
    }

    public void dfs(int i,int n,int cost,int[][] path){
        if(i==n-1){
            cost+=path[lastCity][0];
            minCost =Math.min(minCost,cost);
            return;
        }
        for (int j = 1; j <n; j++) {
            if(!visited[j]){
                visited[j]=true;
                int tmp=lastCity;
                lastCity=j;
                dfs(i+1,n,cost+path[tmp][j],path);
                //状态回溯
                visited[j]=false;
                lastCity=tmp;
            }
        }
    }
}
