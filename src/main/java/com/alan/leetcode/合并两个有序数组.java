package com.alan.leetcode;

public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1=m-1,i2=n-1;
        for (int i = m+n-1; i >=0 ; i--) {
            if(i1==-1) { nums1[i]=nums2[i2]; i2--;}
            else if(i2==-1) { nums1[i]=nums1[i1]; i1--;}
            else if(nums1[i1]>nums2[i2]){
                nums1[i]=nums1[i1]; i1--;
            }else {
                nums1[i]=nums2[i2]; i2--;
            }
        }
    }
}
