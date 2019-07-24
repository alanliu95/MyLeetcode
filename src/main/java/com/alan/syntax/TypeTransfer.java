package com.alan.syntax;

public class TypeTransfer {
    public static void main(String[] args){
        long i=100;
        //java不允许向下隐式类型转换
        //int l=i;
        long l=i+2;
        System.out.println(l);
    }
}
