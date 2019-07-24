package com.alan.syntax;

public class Path {
    public static void main(String args[]) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("user.dir"));
        //System.out.println(new Path().toString());
        System.out.println("  ="+Path.class.getResource(""));
        System.out.println("/="+Path.class.getResource("/"));
        //logger.info("hello");
        return;
    }
}
