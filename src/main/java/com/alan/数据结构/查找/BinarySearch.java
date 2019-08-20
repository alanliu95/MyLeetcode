package com.alan.数据结构.查找;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 5, 7};
        int index = binarySearch(arr, 3);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target < arr[mid]) hi = mid - 1;
            else if (target > arr[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
