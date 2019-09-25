package com.alan.剑指offer;

import java.util.*;

public class 孩子们的游戏圆圈中最后剩下的数 {

    public int LastRemaining_Solution(int n, int m) {
        if (m <= 0 || n <= 0) return -1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);

        }
        return list.remove(0);
    }
}