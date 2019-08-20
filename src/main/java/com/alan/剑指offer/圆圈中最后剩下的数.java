package com.alan.剑指offer;

import java.util.LinkedList;

public class 圆圈中最后剩下的数 {
    public static void main(String[] args) {
        System.out.println(new 圆圈中最后剩下的数().LastRemaining_Solution(5,3));
    }
    public int LastRemaining_Solution(int n, int m) {
        if(m<=0||n<=0) return -1;
        LinkedList<Integer> list=new LinkedList<>();
        for (int i = 0; i <n ; i++) {
            list.add(i);
        }
        int index=0;
        while(list.size()>1){
            //下一个被移除节点的索引
            index = (index + m - 1) % list.size();
            list.remove(index);

        }
        return list.remove(0);
    }
}
