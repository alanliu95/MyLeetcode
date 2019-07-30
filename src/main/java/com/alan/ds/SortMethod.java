package com.alan.ds;

public class SortMethod {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Integer a[]=new Integer[]{3,2,9,5,4};
        mergeSort(a);
        for(Integer e:a)
            System.out.print(e+" ");

//        int N=9;
//        System.out.println(N--);
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
    private static boolean less(Comparable[] a,int i,int j){
        return a[i].compareTo(a[j])<0;
    }

    //插入排序
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
    //插入排序
    public static void insertionSort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i; j>0;j--){
                if(less(a,j,j-1)) exch(a,j-1,j);
                else break;
            }
        }
    }

    //选择排序 简洁写法
    public static void InsertionSort2(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i; j>0&&less(a,j,j-1);j--){
                 exch(a,j-1,j);
            }
        }
    }

    /*************************************************************************
    *
     *              快速排序 是否稳定？
     ************************************************************************/
    public static void fastSort(Comparable[] arr){
    //1. 打乱顺序
        fastSort(arr,0,arr.length-1);
    }
    public static void fastSort(Comparable[] arr, int lo, int hi){
        //递归终止条件
        if(lo>=hi) return;
        int j=partition(arr, lo, hi);
        fastSort(arr,lo,j-1);
        fastSort(arr,j+1,hi);
    }
    public static int partition(Comparable[] arr, int lo, int hi){
        int pivot=lo;
        //最终记录第一个大于 基值 的元素下标
        int index=lo+1;
        for(int i=index;i<=hi;i++){
            if(less(arr,i,pivot))
                exch(arr,i,index++);
        }
        // index减一
        exch(arr,index-1,pivot);
        return index-1;
    }

    /*************************************************************************
     *
     *              归并排序
     ************************************************************************/
    private static Comparable[] aux;
    public static void mergeSort(Comparable[] a){
        aux = new Comparable[a.length];
        mergeSort(a,0,a.length-1);
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
        for(int i=lo;i<=hi;i++)
            aux[i]=arr[i];

        int index=lo;
        int index1=lo,index2=mid+1;

        for(;index<=hi;index++){
            if(index1>mid)
                arr[index]=aux[index2++];
            else if(index2>hi)
                arr[index]=aux[index1++];
            else if(less(aux,index2,index1))
                arr[index]=aux[index2++];
            else
                arr[index]=aux[index1++];

        }

        //这种循环方法不简洁，不如书上 for循环
//        while(index1<=mid||index2<=hi){
//            if(index1>mid) arr[index++]=aux[index2++];
//            else if(index2>hi) arr[index++]=aux[index1++];
//            else if(less(aux,index1,index2)) { arr[index++]=aux[index1++]; }
//            else { arr[index++]=aux[index2++]; }
//        }

    }

//    public static void merge(Comparable[] arr, int head, int mid, int tail){
//
//        int i = head;
//        int j = mid + 1;
//        //Comparable[] aux = new Comparable[tail - head + 1];
//        for (int k = i; k <= tail; k++){
//            aux[k] = arr[k];
//        }
//
//        for (int k = i; k <= tail; k++){
//
//            if (i > mid) arr[k] = aux[j++];
//            else if (j > tail) arr[k] = aux[i++];
//            else if (less(aux,i,j)) arr[k] = aux[i++];
//            else arr[k] = aux[j++];
//
//        }
//    }
    /*************************************************************************
     *
     *              堆排序
     ************************************************************************/
    //使k子树堆有序
    private static void sink(Comparable[] pq, int k, int n){
        while(2*k<n){
            int j=2*k;
            if(j<n&&less(pq,j,j+1)) j++;
            if(!less(pq,k,j)) break;
            exch(pq,k,j);
            k=j;
        }
    }
    //这个方法未使用到，仅练习
    private void swim(Comparable[] pq,int k){
        while(k>1&&less(pq,k/2,k)){
            exch(pq,k,k/2);
            k=k/2;
        }
    }

    public static void heapSort(Comparable[] a){
        //使堆有序
        int N=a.length; //此处书中未减一，运行会出现数组越界
        for (int k = N/2; k >=0 ; k--) {
            sink(a,k,N);
        }
        N--;
        //开始排序
        while(N>0){
            exch(a,0,N--);
            sink(a,0,N);
        }
    }
/**********************************************************************
* 希尔排序
 *
******************************************************************** */

}