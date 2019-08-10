package com.alan.公司.大疆;

/**
 *有一个窃贼在偷窃一家商店时发现有n件物品，第i件物品价值为vi元，重量为wi，假设vi和wi都为整数。
 * 他希望带走的东西越值钱越好，但他的背包中之多只能装下W磅的东西，W为一整数。他应该带走哪几样东西？
 */
public class _01背包 {
    public static void main(String[] args) {
        int[] cj=new int[]{10,18,10,9};
        int[] time=new int[]{2,3,2,1};
        int x=4;
        System.out.println(new _01背包.solution2().getMax(cj,time,x));
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
    /**
     * 暴力枚举方案
     */
    public static class solution2{
        private int sum=Integer.MIN_VALUE;
        public int getMax(int[] cj,int[] time,int x){
            sum=Integer.MIN_VALUE;
            dfs(cj,time,x,0,0);
            return sum;
        }
        void dfs(int[] cj, int[] time, int x,int cnt,int i){
            if(i==cj.length){
                sum=Math.max(sum,cnt);
                return;
            }
            if(x-time[i]>=0)
                dfs(cj,time,x-time[i],cnt+cj[i],i+1);
            dfs(cj,time,x,cnt,i+1);
        }
    }
    /**
     * 暴力枚举方案
     */
    public static class solution{
        int max;
        //int n;
        boolean[] used;
        public int baoli ( int[] cj, int[] time, int x){
            max = Integer.MIN_VALUE;
            int n = cj.length;
            used=new boolean[n];
            dfs(cj,time,x,0);
            return max;
        }
        void dfs(int[] cj, int[] time, int x,int curr){
            for (int i = 0; i < cj.length; i++) {
                if(!used[i]&&x>=time[i]){
                    used[i]=true;
                    dfs(cj,time,x-time[i],curr+cj[i]);
                    used[i]=false;
//                    return;
                }
                max=Math.max(curr,max);

            }
        }
    }
}


