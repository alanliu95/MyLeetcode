package com.alan.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class 约瑟夫环 {
    public static void main(String[] args) {
        System.out.println(new 约瑟夫环().answer(7, 3));
    }

    public ArrayList<Integer> answer(int n, int p) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> seq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            seq.add(i, i + 1);
        }
        int last = 1;
        for (int i = 0; i < n - 1; i++) {
            int index = (p % seq.size() + last - 1) % seq.size();

            if (index == 0) last = 1;
            else last = index;
            if (index == 0) index = seq.size() - 1;
            else index -= 1;
            int val = seq.get(index);
            seq.remove(new Integer(val));
            res.add(val);
        }
        res.add(seq.get(0));
        return res;
    }
}
