package com.alan.数据结构.排序;

/**
 * 时间复杂度
 */
public class Quick extends SortBaseClass {
    public static void main( String[] args )
    {
        Integer arr[]=new Integer[]{3,2,9,4,7,10,1,5,4};
        System.out.print("原来的数组：");printArray(arr);
        QuickSort(arr);
        System.out.print("排序后数组：");printArray(arr);

    }

    public static void QuickSort(Comparable[] arr){
//        List list= Arrays.asList(arr);
//        Collections.shuffle(list);
//        arr=(Comparable[]) list.toArray();

        //首先需要打乱数组元素顺序，消除对输入的依赖
        //利用集合中的方法来打乱数组，比较麻烦,且不是打乱原数组，而是转换成List,打乱List
        //这里实现了一个简单shuffle算法， Fisher–Yates shuffle
        shuffleArray(arr);
        System.out.print("打乱后数组：");printArray(arr);
        QuickSort(arr,0,arr.length-1);
    }

    private static void QuickSort(Comparable[] arr, int lo, int hi){
        //递归终止条件
        if(lo>=hi) return;
        int j=partition(arr, lo, hi);
        QuickSort(arr,lo,j-1);
        QuickSort(arr,j+1,hi);
    }

    /**
     * 以最后一个元素作为切分元素，声明一个变量index作为指针，一开始指向第一个元素，
     * 利用for循环一趟遍历，i=lo开始,i<hi为条件，内部语句判断当前元素与切分元素值的大小，若当前元素小于
     * 切分元素，将该元素与index指向的元素交换位置，index自加
     * 循环结束后，将切分元素与index指向的元素交换位置,返回index 的值（切分元素最终下标）
     * @param arr 数组
     * @param lo  起始点
     * @param hi  终点（包含此位置）
     * @return    基准值最终下标
     */
    private static int partition(Comparable[] arr, int lo, int hi){
        //最后一个元素作为基准值
        int pivot=hi;
        //记录第一个大于基准值的元素下标，遍历完后最终记录第一个大于 基准值 的元素下标
        int index=lo;
        for(int i=lo;i<hi;i++){
            if(less(arr,i,pivot))
                exch(arr,i,index++);
        }
        // 将基准元素与第一个大于他的元素交换
        exch(arr,index,pivot);
        //返回基准值的元素下标
        return index;
    }
}
