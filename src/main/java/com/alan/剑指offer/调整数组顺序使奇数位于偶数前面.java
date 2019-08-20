package com.alan.剑指offer;

public class 调整数组顺序使奇数位于偶数前面 {
    public class Solution {
        public void reOrderArray(int [] array) {
            for(int i=0;i<array.length;i++){
                //int index=i;
                if(array[i]%2==0) continue;
                for(int j=i-1;j>=0;j--){
                    if(array[j]%2==0){
                        int tmp=array[j+1];
                        array[j+1]=array[j];
                        array[j]=tmp;
                    }

                }
            }
        }
    }

}
