package com.alan.offer;

public class 二叉搜索树的后序遍历序列 {
    public class Solution {
        //private int[] seq;
        public boolean VerifySquenceOfBST(int [] sequence) {
            if(sequence==null || sequence.length==0) return false;
            //  seq=sequence;
            return verify(sequence,0,sequence.length-1);
        }
        public boolean verify(int [] arr, int lo, int hi){
            //boolean res;
            if(lo>=hi) return true;
            int root= arr[hi];
            //boolean flag=true;
            int i;
            for(i=hi;i>=lo;i--){
                if(arr[i]<root) break;
            }
            for(;i>=lo;i--){
                if(arr[i]>root) return false;
            }
            return verify(arr,i+1,hi-1)&&verify(arr,lo,i);
        }
    }
}
