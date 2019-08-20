package com.alan.数据结构.排序;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SortBaseClass {
    public static void exch(Comparable[] arr,int i,int j){
        Comparable tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public static boolean less(Comparable[] arr,int i,int j){
        return arr[i].compareTo(arr[j])<0;
    }

    // Implementing Fisher–Yates shuffle
    public static void shuffleArray(Comparable[] arr)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = arr.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Comparable a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }
    public static void printArray(Comparable[] arr){
        for (Comparable e:arr) {
            System.out.printf("%4d",e);
        }
        System.out.println();
    }
}
