package com.alan.syntax.集合;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("abc","efg","123","456");
        list.forEach((e)-> System.out.println(e));
    }
}
