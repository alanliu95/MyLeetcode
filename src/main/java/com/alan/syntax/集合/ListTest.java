package com.alan.syntax.集合;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list1.addAll(list2);
        list2.clear();
        System.out.println(list1);
//        System.out.println(list2);
    }
}
