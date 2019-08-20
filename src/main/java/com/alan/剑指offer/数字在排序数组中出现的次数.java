package com.alan.剑指offer;

public class 数字在排序数组中出现的次数 {
    public int GetNumberOfK(int[] array, int k) {
        return binarySearch(array, k + 0.5) - binarySearch(array, k - 0.5);
    }

    public int binarySearch(int[] array, double k) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (array[mid] < k) lo = mid + 1;
            if (array[mid] > k) hi = mid - 1;
        }
        return hi;
    }

//    public int GetNumberOfK2(int [] array , int k) {
//        int lo=0,hi=array.length-1;
//        while(lo<=hi){
//            int mid=(lo+hi)/2;
//            if(array[mid]<k) lo=mid+1;
//            if(array[mid]>k) hi=mid-1;
//        }
//        int start=lo;
//
//        lo=0; hi=array.length;
//        while(lo<=hi){
//            int mid=(lo+hi)/2;
//            if(array[mid]<=k) lo=mid+1;
//            if(array[mid]>k) hi=mid-1;
//        }
//        int end=hi;
//        return end-start;
//    }
}
