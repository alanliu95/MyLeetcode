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

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0)
            return;
        int i = m - 1, j = n - 1;
        for (int k = nums1.length - 1; k >= 0; k--) {
            if (i < 0)
                nums1[k] = nums2[j--];
            else if (j < 0)
                nums1[k] = nums1[i--];
            else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else
                nums1[k] = nums2[j--];
        }
    }
}
