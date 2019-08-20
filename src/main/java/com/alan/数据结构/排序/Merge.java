package com.alan.数据结构.排序;

public class Merge extends SortBaseClass {
    public static void main( String[] args )
    {
        Integer arr[]=new Integer[]{3,2,9,4,7,10,1,5,4};
        System.out.print("原来的数组：");printArray(arr);
        mergeSort(arr);
        System.out.print("排序后数组：");printArray(arr);

    }
    private static Comparable[] aux;
    public static void mergeSort(Comparable[] a){
        //初始化辅助数组
        aux = new Comparable[a.length];
        mergeSort(a,0,a.length-1);
        //移除引用，使GC工作
        aux=null;
    }
    public static void mergeSort(Comparable[] arr, int lo, int hi){
        if(lo>=hi) return;
        int mid =(lo+hi)/2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid+1, hi);
        merge(arr,lo,mid,hi);
    }
    public static void merge(Comparable[] arr, int lo, int mid, int hi){
        //将待归并的元素拷贝到辅助数组
        for(int i=lo;i<=hi;i++)
            aux[i]=arr[i];

        //arr[lo ... mid]
        int index1=lo;
        //arr[mid+1 ... hi]
        int index2=mid+1;

        //这里分支书写顺序需要和书上完全保持一致，不然考虑不周会进错分支，导致bug
        for(int index=lo;index<=hi;index++){
            //左数组已经移空
            if(index1>mid)                      arr[index]=aux[index2++];
            //右数组已经移空
            else if(index2>hi)                  arr[index]=aux[index1++];
            else if(less(aux,index2,index1))    arr[index]=aux[index2++];
            else                                arr[index]=aux[index1++];

        }

        //这种循环方法不简洁，不如书上 for循环
//        while(index1<=mid||index2<=hi){
//            if(index1>mid) arr[index++]=aux[index2++];
//            else if(index2>hi) arr[index++]=aux[index1++];
//            else if(less(aux,index1,index2)) { arr[index++]=aux[index1++]; }
//            else { arr[index++]=aux[index2++]; }
//        }

    }


}
