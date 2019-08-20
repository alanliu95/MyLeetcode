package com.alan.数据结构.排序;

public class Selection extends SortBaseClass{
    public static void main( String[] args )
    {
        Integer arr[]=new Integer[]{3,2,9,4,7,10,1,5,4};
        System.out.print("原来的数组：");printArray(arr);
        selectionSort(arr);
        System.out.print("排序后数组：");printArray(arr);

    }
    public static void selectionSort(Comparable[] a){
        int N=a.length;
        for(int i=0;i<N;i++){
            int min=i;
            for(int j=i+1;j<N;j++){
                if(less(a,j,min))
                    min=j;
            }
            exch(a,i,min);
        }
    }
}
