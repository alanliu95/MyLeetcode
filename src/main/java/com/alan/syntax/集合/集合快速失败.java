package com.alan.syntax.集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 集合快速失败 {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3};
        copyArray(integers);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }

    public static void fastFailed() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        for (Integer integer : list) {
            list.add(5);
            System.out.println(integer);
        }
        System.out.println(list);
    }

    public static void copyArray(Object[] objects) {
        objects[0] = 10086;
        for (Object object : objects) {
            System.out.print(object + " ");
        }
        System.out.println();
    }

}
