package com.alan.公司.大疆;

/**
 * 机器人每次从第0点出发，需要依次到其他点打卡，两个点之间至少有一条路径连通
 */
public class 机器人比赛最短时间 {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{0,15,0,50},{0,0,15,0},{0,0,0,10},{0,0,0,0}};
        System.out.println(arr);
        int[] target=new int[]{2,1,3};
        int score=0;
        for(int e:target){
            score+=find(arr,e);
        }
        System.out.println(score);
    }
    public  static int find(int [][] arr, int index){
            //if(index==1) return
            int score=Integer.MAX_VALUE;
            for(int i=0;i<index;i++){
                if(arr[i][index]==0)
                    continue;
                Math.min(find(arr,i),score);

            }
        return score;
            //if(arr[0][index]==)

    }

}

