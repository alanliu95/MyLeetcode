package com.alan.ds.排序;

public class Heap extends SortBaseClass{
    public static void main( String[] args )
    {
        Integer arr[]=new Integer[]{3,2,1,4,6,7,1};
        //Integer arr[]=new Integer[]{2,1,1};
        System.out.print("原来的数组：");printArray(arr);
        heapSort(arr);
        System.out.print("排序后数组：");printArray(arr);

    }
    /**
     * 这里假设元素k对应子树原来堆有序，现在k元素值变化，调整子树重新堆有序
     * 这里的子节点下标是 k*2+1 k*2=2
     * @param pq 数组引用
     * @param fatherIndex  子树的根节点下标
     * @param n  此时二叉堆长度
     */
    private static void sink(Comparable[] pq, int fatherIndex, int n){
        while(2*fatherIndex+1<n){
            //子节点下标
            int childIndex=2*fatherIndex+1;
            //若存在右子节点，找到较大子节点
            if(childIndex+1<n && less(pq,childIndex,childIndex+1)) childIndex++;
            //若父节点比最大子节点小，交互位置，继续下沉
            //判断父节点是否比最大子节点大，说明堆有序，跳出循环
            if(less(pq,childIndex,fatherIndex))
                break;
            exch(pq,fatherIndex,childIndex);
            //下沉
            fatherIndex=childIndex;
        }
    }
    //这个方法未使用到，仅练习
    //优先队列中会用到，当添加新元素时，放到数组最后面，不断上浮恢复堆有序
    private void swim(Comparable[] pq,int k){
        while(k>1&&less(pq,k/2,k)){
            exch(pq,k,k/2);
            k=k/2;
        }
    }

/**
 * 二叉堆是完全二叉树，可以直接用数组表示
    1.首先把数组当成完全二叉树，从n/2处元素开始，调整位置，使子树堆有序（最大堆）
    2.将第一个元素（最小值）与第N-1个元素交换位置，使请前N-1个元素重新堆有序，
    3.swap(1,N-2) sink(arr,0,N-3) 重复下去
*/
    public static void heapSort(Comparable[] arr){
        //使堆有序
        int N=arr.length;
        //k的取值范围
        for (int k = N/2; k >=0 ; k--) {
            sink(arr,k,N);
        }
        //开始排序
        for (int i = N-1; i >0 ; i--) {
            exch(arr,0,i);
            sink(arr,0,i);
        }
    }
}
