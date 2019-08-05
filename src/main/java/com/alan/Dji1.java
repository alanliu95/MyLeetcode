package com.alan;

public class Dji1 {
    public static void main(String[] args) {
//         double result;
//        double[] arr1=new double[]{4,3,3};
//        double[] arr2=new double[]{333,77,100,50};
//        double coffe=60*arr1[1]*arr1[2];
//        double count=0;
//        for(double e:arr2)
//            count+=e;
//        if(coffe-count>0){
//            result=count/arr1[2];
//        }
//        else{
//             result=60*arr1[2]+count-coffe;
//        }
//        System.out.println(result);
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

