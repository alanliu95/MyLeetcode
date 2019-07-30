package com.alan.ds;

public class MaxPQ {
    private  Comparable[] pq;
    private  int N;
    private  void exch(int i,int j){
        Comparable tmp=pq[i];
        pq[i]=pq[j];
        pq[j]=tmp;
    }
    private  boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }



}
