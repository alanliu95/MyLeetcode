package com.alan.数据结构;

import com.alan.数据结构.排序.SortBaseClass;

/**
 * 如果想要实现一个没有边界的优先队列，内部需要使用可变长数组
 * 从队列移除一个元素（数组中第一个元素，最大值）后需要调用sink() 使堆重新有序
 * 从队列添加一个元素（往数组尾部添加一个元素）后需要调用swim() 使堆重新有序
 */
public class MaxPQ extends SortBaseClass {
    private  Comparable[] pq;
    private  int N;

}
