package com.alan.数据结构.排序;
/**
*直接插入排序（稳定）
*原理：将数组分为无序区和有序区两个区，然后不断将无序区的第一个元素按大小顺序插入到有序区中去，最终将所有无序区元素都移动到有序区完成排序。
*要点：设立哨兵，作为临时存储和判断数组边界之用。
 **/
public class Insertion extends SortBaseClass{
    public static void main( String[] args )
    {
        Integer arr[]=new Integer[]{3,2,9,4,7,10,1,5,4};
        System.out.print("原来的数组：");printArray(arr);
        insertionSort(arr);
        System.out.print("排序后数组：");printArray(arr);

    }
    public static void insertionSort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i; j>0;j--){
                if(less(a,j,j-1)) exch(a,j-1,j);
                else break;
            }
        }
    }
    //插入排序 简洁写法
    public static void InsertionSort2(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i; j>0&&less(a,j,j-1);j--){
                exch(a,j-1,j);
            }
        }
    }
}
