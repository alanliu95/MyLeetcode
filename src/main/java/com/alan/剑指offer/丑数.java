package com.alan.剑指offer;

public class 丑数 {
    public static void main(String[] args) {
        new Solution().GetUglyNumber_Solution(7);
    }
    public static class Solution {
        public int GetUglyNumber_Solution(int index) {
            if(index<=0) return 0;
            int[] arr=new int[index];
            arr[0]=1;
            int i2=0,i3=0,i5=0;
            for(int i=1;i<index;i++){
                int m2=arr[i2]*2;
                int m3=arr[i3]*3;
                int m5=arr[i5]*5;
                arr[i]=Math.min(m2,Math.min(m3,m5));
                if(arr[i]==m2) i2++;
                if(arr[i]==m3) i3++;
                if(arr[i]==m5) i5++;
            }
            return arr[index-1];

        }
    }
}
