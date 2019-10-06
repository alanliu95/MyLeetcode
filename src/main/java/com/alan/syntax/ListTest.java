package com.alan.syntax;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer>  list=new ArrayList<>();
        list.add(0,1);
        list.add(1,11);
        System.out.println(list);
    }
}
