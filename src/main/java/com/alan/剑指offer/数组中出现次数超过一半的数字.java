package com.alan.剑指offer;

public class 数组中出现次数超过一半的数字 {
    public static class Solution {
        public int MoreThanHalfNum_Solution(int [] array) {
            int len=array.length;
            int mid=len/2;
            int index=0,lo=0,hi=len-1;
            index=partition(array,lo,hi);
            while(index!=mid){
                if(index>mid)
                    index=partition(array,lo,index-1);
                else
                    index=partition(array,index+1,hi);
            }
            int res=array[mid],times=0;
            for(int i=0;i<len;i++){
                if(array[i]==res)
                    times++;
            }
            if(times>mid)
                return res;
            else
                return 0;
        }
        public static int partition(int[] arr,int lo, int hi){
            int index=lo+1;
            for(int i=lo;i<=hi;i++){
                if(arr[i]<arr[lo]){
                    int tmp=arr[i]; arr[i]=arr[index]; arr[index]=tmp;
                    index++;
                }
            }
            int tmp=arr[lo]; arr[lo]=arr[index-1]; arr[index-1]=tmp;
            return index-1;
        }
    }
}
