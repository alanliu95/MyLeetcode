package com.alan.剑指offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口的最大值 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null) {
            return ret;
        }
        if (num.length < size || size < 1) {
            return ret;
        }
        Deque<Integer> indexDeq = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            if (!indexDeq.isEmpty() && num[i] > num[indexDeq.getLast()]) {
                indexDeq.removeLast();
            }
            indexDeq.addLast(i);
        }
        for (int i = size - 1; i < num.length; i++) {
            while (!indexDeq.isEmpty() && num[i] > num[indexDeq.getLast()]) {
                indexDeq.removeLast();
            }
            indexDeq.addLast(i);
            if (i - indexDeq.getFirst() + 1 > size)
                indexDeq.removeFirst();
            ret.add(num[indexDeq.getFirst()]);
        }
        return ret;
    }
}
