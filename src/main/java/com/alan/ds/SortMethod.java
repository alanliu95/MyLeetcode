package com.alan.ds;

public class SortMethod {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Integer a[]=new Integer[]{3,2,9,5,4};
        mergeSort(a);
        for(Integer e:a){
            System.out.print(e+" ");
        }
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    //插入排序
    public static void SelectionSort(Comparable[] a){
        int N=a.length;
        for(int i=0;i<N;i++){
            int min=i;
            for(int j=i+1;j<N;j++){
                if(less(a[j],a[min]))
                    min=j;
            }
            exch(a,i,min);
        }
    }
    //选择排序
    public static void InsertionSort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i; j>0;j--){
                if(less(a[j],a[j-1])) exch(a,j-1,j);
                else break;
            }
        }
    }

    //选择排序 简洁写法
    public static void InsertionSort2(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i; j>0&&less(a[j],a[j-1]);j--){
                 exch(a,j-1,j);
            }
        }
    }

    /*************************************************************************
    *
     *              快速排序 是否稳定？
     ************************************************************************/
    public static void fastSort(Comparable[] a){
    //1. 打乱顺序
        fastSort(a,0,a.length-1);
    }
    public static void fastSort(Comparable[] a, int lo, int hi){
        //递归终止条件
        if(lo>hi) return;
        int j=partition(a, lo, hi);
        fastSort(a,lo,j-1);
        fastSort(a,j+1,hi);
    }
    public static int partition(Comparable[] a, int lo, int hi){
        Comparable sep=a[hi];
        int index=lo;
        for(int i=lo;i<hi;i++){
            if(less(a[i],sep)) exch(a,i,index++);
        }
        exch(a,index,hi);
        return index;
    }

    /*************************************************************************
     *
     *              归并排序
     ************************************************************************/
    private static Comparable[] aux;
    public static void mergeSort(Comparable[] a){
        aux = new Comparable[a.length];
        mergeSort(a,0,a.length-1);
    }
    public static void mergeSort(Comparable[] a, int lo, int hi){
        if(hi<=lo) return;
        int mid =(lo+hi)/2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid+1, hi);
        merge(a,lo,mid,hi);
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        for(int i=lo;i<=hi;i++)
            aux[i]=a[i];
        int index1=lo,index2=mid+1,index=lo;
        while(index1<=mid||index2<=hi){
            if(index1>mid) a[index++]=aux[index2++];
            else if(index2>hi) a[index++]=aux[index1++];
            else if(less(aux[index1],aux[index2])) { a[index++]=aux[index1++]; }
            else { a[index++]=aux[index2++]; }
        }
    }
    /*************************************************************************
     *
     *              堆排序
     ************************************************************************/

}
