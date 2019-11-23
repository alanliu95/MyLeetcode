package com.alan.syntax.集合;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * LinkHashMap 可以同时记录元素的插入顺序，或者访问顺序
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        System.out.println(entrySet);
        map.put(2, 22);
        System.out.println(entrySet);
    }
}
