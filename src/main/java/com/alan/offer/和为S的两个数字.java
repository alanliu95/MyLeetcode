package com.alan.offer;

import java.util.ArrayList;
public class 和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(array==null||array.length<2) return res;
        int i=0,j=array.length-1;
        int min=Integer.MAX_VALUE, ii=0,jj=0;
        while(i<j){
            if(array[i]+array[j]<sum) i++;
            else if(array[i]+array[j]>sum) j--;
            else {
                if(min>array[i]*array[j]){
                    min=array[i]*array[j];
                    ii=i;jj=j;

                }
                i++;
            }

        }
        if(ii==0&&jj==0) return res;
        res.add(array[ii]);
        res.add(array[jj]);
        return res;

    }
}
