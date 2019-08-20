package com.alan.剑指offer;

public class 构建乘积数组 {
    public int[] multiply(int[] A) {
        if(A==null || A.length==0) return new int[0];
        int len=A.length;
        int[] res=new int[len];
        res[0]=1;
        for(int i=1;i<len;i++){
            res[i]=res[i-1]*A[i-1];
        }
        int temp=1;
        for(int i=len-2;i>=0;i--){
            temp*=A[i+1];
            res[i]*=temp;
        }
        return res;
    }
}
